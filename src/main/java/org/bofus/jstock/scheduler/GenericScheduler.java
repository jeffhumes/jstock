package org.bofus.jstock.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bofus.jstock.config.MarketConfig;
import org.bofus.jstock.service.CommonService;
import org.bofus.jstock.service.FinnHubService;
import org.bofus.jstock.util.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
public class GenericScheduler {
  @Autowired MarketConfig marketConfig;

  @Autowired ArrayUtils arrayUtils;

  @Autowired FinnHubService finnHubService;

  @Autowired CommonService commonService;

  @Scheduled(cron = "* * 22 * * ?")
  public void getExchangeSpreadsheet() throws MalformedURLException, IOException {
    String url = marketConfig.getMarketInfoDownloadLocation();
    String tmpdir = System.getProperty("java.io.tmpdir");
    String fileLocation = tmpdir + File.separatorChar + "exchange.xlsx";

    log.debug(String.format("Retrieving file: %s", url));
    log.debug(String.format("Will place file in %s", fileLocation));

    try {
      ReadableByteChannel readChannel = Channels.newChannel(new URL(url).openStream());
      FileOutputStream fileOS = new FileOutputStream(fileLocation);
      FileChannel writeChannel = fileOS.getChannel();
      writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  @Scheduled(cron = "* * 23 * * ?")
  public void populateExchangeData() {
    log.debug("Starting populateExchangeData");
    String tmpdir = System.getProperty("java.io.tmpdir");
    String fileLocation = tmpdir + File.separatorChar + "exchange.xlsx";
    List<String> countryCodeList = new ArrayList<>();

    try (FileInputStream fis = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(fis); ) {
      Sheet sheet = workbook.getSheetAt(0);
      Row headerRow = sheet.getRow(0);
      int countryCodeColumnIndex = 0;

      for (Cell cell : headerRow) {
        if (cell.getStringCellValue().equalsIgnoreCase("ISO COUNTRY CODE (ISO 3166)")) {
          countryCodeColumnIndex = cell.getColumnIndex();
          log.debug(
              String.format(
                  "FOUND ISO COUNTRY CODE (ISO 3166) at column index %s", countryCodeColumnIndex));
        }
      }

      // NOTE: Populate the list of country codes
      for (Row row : sheet) {
        Cell cell = row.getCell(countryCodeColumnIndex);
        countryCodeList.add(cell.getStringCellValue());
      }
    } catch (IOException e) {
      log.error(e.getLocalizedMessage());
    }

    log.debug(String.format("Country Code List size before de-dupe: %s", countryCodeList.size()));

    // NOTE: De-duplicate the list of country codes
    arrayUtils.deDupeStringList(countryCodeList);

    log.debug(String.format("Country Code List size after de-dupe: %s", countryCodeList.size()));

    log.debug(countryCodeList.toString());

    // commonService.populateExchangeCountryData(countryCodeList);

    for (String exchangeCode : countryCodeList) {
      commonService.populateExchangeCountryDataSingle(exchangeCode);
    }
  }
}
