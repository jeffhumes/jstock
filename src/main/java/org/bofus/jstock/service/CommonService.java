package org.bofus.jstock.service;

import java.util.List;

public interface CommonService {
  public void populateExchangeCountryData(List<String> exchangeData);

  public void populateExchangeCountryDataSingle(String exchangeCode);
}
