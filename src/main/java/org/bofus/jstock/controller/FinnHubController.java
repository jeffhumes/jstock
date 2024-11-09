package org.bofus.jstock.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.config.FinnHubConfig;
import org.bofus.jstock.domain.FinnHubMarketHolidays.HolidayRoot;
import org.bofus.jstock.domain.FinnHubMarketStatus;
import org.bofus.jstock.service.FinnHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RestController
@RequestMapping("/finnhub")
public class FinnHubController {

  @Autowired FinnHubConfig finnHubConfig;

  @Autowired FinnHubService finnHubService;

  @GetMapping("/getMarketStatus")
  public List<FinnHubMarketStatus> getMarketStatus() {
    List<String> exchangeCodeList = new ArrayList<>();
    exchangeCodeList.add("US");
    List<FinnHubMarketStatus> returnEntity = new ArrayList();
    log.debug("Entering GetMapping: /getMarketStatus");
    log.debug(finnHubConfig.getBaseUrl());
    log.debug(finnHubConfig.getApiKey());
    log.debug(finnHubConfig.getMarket_status_endpoint());
    returnEntity = finnHubService.getMarketStatus(exchangeCodeList);
    return returnEntity;
  }

  @GetMapping("/getMarketHolidays")
  public List<HolidayRoot> getMarketHolidays() {
    List<String> exchangeCodeList = new ArrayList<>();
    exchangeCodeList.add("US");
    List<HolidayRoot> returnEntity = new ArrayList();
    log.debug("Entering GetMapping: /getMarketStatus");
    log.debug(finnHubConfig.getBaseUrl());
    log.debug(finnHubConfig.getApiKey());
    log.debug(finnHubConfig.getMarket_status_endpoint());
    returnEntity = finnHubService.getMarketHolidays(exchangeCodeList);
    return returnEntity;
  }
}
