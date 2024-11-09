package org.bofus.jstock.domain.FinnHubMarketHolidays;

import lombok.Data;

@Data
public class Holiday {
  public String eventName;
  public String atDate;
  public String tradingHour;
}
