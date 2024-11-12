package org.bofus.jstock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.bofus.jstock.domain.ExchangeCountryCodes;

@Mapper
public interface FinnHubMapper {

  List<ExchangeCountryCodes> getUsExchangeCode();
}
