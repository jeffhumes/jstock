package org.bofus.jstock.domain.FinnHubMarketHolidays;

import java.util.ArrayList;
import lombok.Data;

@Data
public class HolidayRoot {
  public ArrayList<Holiday> data;
  public String exchange;
  public String timezone;

  // FIXME: these are for use in populating the database until I figure out how to
  // use mybatis with embedded objects
  public String eventName;
  public String atDate;
  public String tradingHour;
}
