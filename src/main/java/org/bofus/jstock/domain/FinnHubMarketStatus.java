package org.bofus.jstock.domain;

import lombok.Data;

@Data
public class FinnHubMarketStatus {
  private String exchange;
  private String holiday;
  private String isOpen;
  private String session;
  private String t;
  private String timezone;
}
