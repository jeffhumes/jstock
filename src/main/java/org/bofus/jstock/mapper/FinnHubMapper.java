package org.bofus.jstock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bofus.jstock.domain.FinnHubMarketHolidays.HolidayRoot;

@Mapper
public interface FinnHubMapper {
  public void populateHolidayTable(@Param("holidayRoot") HolidayRoot holidayRoot);
}
