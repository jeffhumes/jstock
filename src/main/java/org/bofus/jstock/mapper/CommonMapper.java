package org.bofus.jstock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bofus.jstock.domain.ExchangeCountryCodes;

@Mapper
public interface CommonMapper {
  public void populateExchangeCountryData(@Param("exchangeData") List<String> exchangeData);

  public void populateExchangeCountryDataSingle(@Param("exchangeCode") String exchangeCode);

  public List<ExchangeCountryCodes> getExchangeCountryList();
}
