package org.bofus.jstock.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.domain.ExchangeCountryCodes;
import org.bofus.jstock.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {
  @Autowired CommonMapper commonMapper;

  public void populateExchangeCountryData(List<String> exchangeData) {
    commonMapper.populateExchangeCountryData(exchangeData);
  }

  public void populateExchangeCountryDataSingle(String exchangeCode) {
    commonMapper.populateExchangeCountryDataSingle(exchangeCode);
  }

  public List<ExchangeCountryCodes> getExchangeCountryList() {
    return commonMapper.getExchangeCountryList();
  }
}
