package org.bofus.jstock.service;

import java.util.List;
import org.bofus.jstock.domain.FinnHubMarketStatus;

public interface FinnHubService {

  public List<FinnHubMarketStatus> getMarketStatus(List<String> exchangeCodeList);
}