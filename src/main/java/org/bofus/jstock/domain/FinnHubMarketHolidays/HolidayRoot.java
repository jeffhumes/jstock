package org.bofus.jstock.domain.FinnHubMarketHolidays;

import java.util.ArrayList;
import lombok.Data;

@Data
public class HolidayRoot {
  public ArrayList<Holiday> data;
  public String exchange;
  public String timezone;

  // FIXME: remove these after you figure out complex embedded objects in mybatis
  public String eventName;
  public String atDate;
  public String tradingHour;
}
