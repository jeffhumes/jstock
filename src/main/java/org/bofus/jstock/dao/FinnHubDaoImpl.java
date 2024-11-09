package org.bofus.jstock.dao;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.config.FinnHubConfig;
import org.bofus.jstock.domain.FinnHubMarketHolidays.HolidayRoot;
import org.bofus.jstock.domain.FinnHubMarketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class FinnHubDaoImpl implements FinnHubDao {
  @Autowired FinnHubConfig config;

  public List<FinnHubMarketStatus> getMarketStatus(List<String> exchangeCodeList) {

    RestClient restClient = RestClient.create();

    List<FinnHubMarketStatus> returnList = new ArrayList<>();

    for (String exchangeCode : exchangeCodeList) {
      log.debug(String.format("Getting market status for exchange: %s", exchangeCode));

      String restUri =
          String.format(
              "%s%s?exchange=%s",
              config.getBaseUrl(), config.getMarket_status_endpoint(), exchangeCode);

      FinnHubMarketStatus thisObject =
          restClient
              .get()
              .uri(restUri)
              .header("X-Finnhub-Token", config.getApiKey())
              .retrieve()
              .body(FinnHubMarketStatus.class);

      log.debug("debug point");
      returnList.add(thisObject);
    }

    return returnList;
  }

  public List<HolidayRoot> getMarketHolidays(List<String> exchangeCodeList) {
    RestClient restClient = RestClient.create();

    List<HolidayRoot> returnList = new ArrayList<>();

    for (String exchangeCode : exchangeCodeList) {
      log.debug(String.format("Getting Market Holiday list for exchange: %s", exchangeCode));

      String restUri =
          String.format(
              "%s%s?exchange=%s",
              config.getBaseUrl(), config.getMarket_holiday_endpoint(), exchangeCode);

      HolidayRoot thisObject =
          restClient
              .get()
              .uri(restUri)
              .header("X-Finnhub-Token", config.getApiKey())
              .retrieve()
              .body(HolidayRoot.class);

      returnList.add(thisObject);
    }

    return returnList;
  }
}
