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
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bofus.jstock.config.MarketConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
public class GenericScheduler {
  @Autowired MarketConfig marketConfig;

  // @Scheduled(cron = "0 */100 * * * ?")
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

  @Scheduled(cron = "0 */1 * * * ?")
  public void populateExchangeData() {
    log.debug("Starting populateExchangeData");
    String tmpdir = System.getProperty("java.io.tmpdir");
    String fileLocation = tmpdir + File.separatorChar + "exchange.xlsx";

    try (FileInputStream fis = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(fis); ) {
      Sheet sheet = workbook.getSheetAt(0);
      for (Row row : sheet) {
        for (Cell cell : row) {
          switch (cell.getCellType()) {
            case STRING:
              log.debug(String.format("%s", cell.getStringCellValue()));
              break;
            case NUMERIC:
              log.debug(String.format("%s", cell.getNumericCellValue()));
              break;
            case BOOLEAN:
              log.debug(String.format("%s", cell.getBooleanCellValue()));
              break;
            case FORMULA:
              log.debug(String.format("%s", cell.getCellFormula()));
              break;
            default:
              log.debug("Could not determine Cell Type");
          }
        }
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}