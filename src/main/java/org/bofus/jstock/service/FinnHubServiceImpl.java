package org.bofus.jstock.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.dao.FinnHubDao;
import org.bofus.jstock.domain.FinnHubMarketHolidays.HolidayRoot;
import org.bofus.jstock.domain.FinnHubMarketStatus;
import org.bofus.jstock.mapper.FinnHubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FinnHubServiceImpl implements FinnHubService {
  @Autowired FinnHubDao dao;
  @Autowired FinnHubMapper mapper;

  @Override
  public List<FinnHubMarketStatus> getMarketStatus(List<String> exchangeCodeList) {
    return dao.getMarketStatus(exchangeCodeList);
  }

  public List<HolidayRoot> getMarketHolidays(List<String> exchangeCodeList) {
    return dao.getMarketHolidays(exchangeCodeList);
  }

  public void populateHolidayTable(HolidayRoot holidayRoot) {
    log.debug(holidayRoot.toString());
    mapper.populateHolidayTable(holidayRoot);
  }
}
