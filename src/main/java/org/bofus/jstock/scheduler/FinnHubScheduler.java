package org.bofus.jstock.scheduler;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.config.MarketConfig;
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

  @Scheduled(cron = "0 */1 * * * ?")
  public void scheduledTaskGetMarketHolidays() {

    long now = System.currentTimeMillis() / 1000;
    log.debug("schedule tasks using cron jobs - " + now);

    List<String> exchangeCodeList = marketConfig.getAvailableMarkets();
    log.debug("debug point");
    // finnHubService.getMarketHolidays(exchangeCodeList);
  }
}
