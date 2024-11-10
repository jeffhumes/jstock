package org.bofus.jstock.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@Configuration
@EnableScheduling
public class FinnHubScheduler {

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
