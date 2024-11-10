package org.bofus.jstock.scheduler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.config.MarketConfig;
import org.bofus.jstock.service.FinnHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@Configuration
@EnableScheduling
public class FinnHubScheduler {
  @Autowired MarketConfig marketConfig;

  @Autowired FinnHubService finnHubService;

  // @Scheduled(cron = l"0 */1 * * * ?")
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

  // TODO: change the frequency to something realistic
  // @Scheduled(cron = "0 */1 * * * ?")
  // public void scheduledTaskGetMarketHolidays() {
  // // TODO: complete populating database table with results from this API call
  // List<String> exchangeCodeList = marketConfig.getAvailableMarkets();
  // List<HolidayRoot> holidays =
  // finnHubService.getMarketHolidays(exchangeCodeList);

  // for (HolidayRoot holidayRoot : holidays) {
  // log.debug(holidayRoot.getExchange());
  // log.debug(holidayRoot.getTimezone());

  // // NOTE: Iterate through each object in 'data' and populate the database
  // table
  // // for holidays
  // for (Holiday holiday : holidayRoot.getData()) {
  // HolidayRoot thisHoliday = new HolidayRoot();
  // thisHoliday.setExchange(holidayRoot.getExchange());
  // thisHoliday.setTimezone(holidayRoot.getTimezone());
  // thisHoliday.setAtDate(holiday.getAtDate());
  // thisHoliday.setEventName(holiday.getEventName());
  // thisHoliday.setTradingHour(holiday.getTradingHour());
  // log.debug(thisHoliday.toString());
  // finnHubService.populateHolidayTable(thisHoliday);
  // }
  // }
  // }
}
