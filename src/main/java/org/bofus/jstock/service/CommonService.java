package org.bofus.jstock.service;

import java.util.List;
import org.bofus.jstock.domain.ExchangeCountryCodes;

public interface CommonService {
  public void populateExchangeCountryData(List<String> exchangeData);

  public void populateExchangeCountryDataSingle(String exchangeCode);

  public List<ExchangeCountryCodes> getExchangeCountryList();
}
