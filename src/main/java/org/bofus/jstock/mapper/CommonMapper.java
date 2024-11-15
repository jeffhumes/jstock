package org.bofus.jstock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommonMapper {
  public void populateExchangeCountryData(@Param("exchangeData") List<String> exchangeData);

  public void populateExchangeCountryDataSingle(@Param("exchangeCode") String exchangeCode);
}