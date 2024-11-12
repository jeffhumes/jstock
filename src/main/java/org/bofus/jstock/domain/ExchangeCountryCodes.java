package org.bofus.jstock.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ExchangeCountryCodes {
  private String exchangeCode;
  private int id;
}
