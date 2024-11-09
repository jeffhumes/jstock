package org.bofus.jstock.dao;

import java.util.List;
import org.bofus.jstock.domain.FinnHubMarketHolidays.HolidayRoot;
import org.bofus.jstock.domain.FinnHubMarketStatus;

public interface FinnHubDao {
  public List<FinnHubMarketStatus> getMarketStatus(List<String> exchangeCodeList);

  public List<HolidayRoot> getMarketHolidays(List<String> exchangeCodeList);
}
