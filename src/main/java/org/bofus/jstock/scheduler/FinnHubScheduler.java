package org.bofus.jstock.scheduler;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.config.MarketConfig;
import org.bofus.jstock.domain.FinnHubMarketHolidays.Holiday;
import org.bofus.jstock.domain.FinnHubMarketHolidays.HolidayRoot;
import org.bofus.jstock.service.FinnHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
public class FinnHubScheduler {

  @Autowired MarketConfig marketConfig;

  @Autowired FinnHubService finnHubService;

  // // TODO: change the frequency to something realistic
  // @Scheduled(cron = "0 */1 * * * ?")
  // public void scheduledTaskGetMarketHolidays() {
  // // TODO: complete populating database table with results from this API call
  // List<String> exchangeCodeList = marketConfig.getAvailableMarkets();
  // List<HolidayRoot> holidays =
  // finnHubService.getMarketHolidays(exchangeCodeList);

  // for (HolidayRoot holidayRoot : holidays) {
  // log.debug(holidayRoot.getExchange());
  // log.debug(holidayRoot.getTimezone());

  // log.debug(
  // String.format(
  // "Updating holiday information for exchange: %s in timezone: %s",
  // holidayRoot.getExchange(), holidayRoot.getTimezone()));

  // finnHubService.populateHolidayTable(holidayRoot);
  // // NOTE: Iterate through each object in 'data' and populate the database
  // table
  // // for holidays
  // // for (Holiday holiday : holidayRoot.getData()) {
  // // HolidayRoot thisHoliday = new HolidayRoot();
  // // thisHoliday.setExchange(holidayRoot.getExchange());
  // // thisHoliday.setTimezone(holidayRoot.getTimezone());
  // // thisHoliday.setAtDate(holiday.getAtDate());
  // // thisHoliday.setEventName(holiday.getEventName());
  // // thisHoliday.setTradingHour(holiday.getTradingHour());
  // // log.debug(thisHoliday.toString());
  // // finnHubService.populateHolidayTable(thisHoliday);
  // // }
  // }
  // }

  // TODO: change the frequency to something realistic
  @Scheduled(cron = "* * 23 * * ?")
  public void scheduledTaskGetMarketHolidays() {
    // TODO: complete populating database table with results from this API call
    List<String> exchangeCodeList = marketConfig.getAvailableMarkets();
    List<HolidayRoot> holidays = finnHubService.getMarketHolidays(exchangeCodeList);

    for (HolidayRoot holidayRoot : holidays) {
      log.debug(holidayRoot.getExchange());
      log.debug(holidayRoot.getTimezone());

      log.debug(
          String.format(
              "Updating holiday information for exchange: %s in timezone: %s",
              holidayRoot.getExchange(), holidayRoot.getTimezone()));

      // FIXME: remove these after you figure out complex embedded objects in mybatis
      // and we can just send the complex object
      // NOTE: Iterate through each object in 'data' and populate the database table
      for (Holiday holiday : holidayRoot.getData()) {
        HolidayRoot thisHoliday = new HolidayRoot();
        thisHoliday.setExchange(holidayRoot.getExchange());
        thisHoliday.setTimezone(holidayRoot.getTimezone());
        thisHoliday.setAtDate(holiday.getAtDate());
        thisHoliday.setEventName(holiday.getEventName());
        thisHoliday.setTradingHour(holiday.getTradingHour());
        log.debug(thisHoliday.toString());
        finnHubService.populateHolidayTable(thisHoliday);
      }
    }
  }
}
