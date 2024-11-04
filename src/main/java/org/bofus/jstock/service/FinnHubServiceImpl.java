package org.bofus.jstock.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.dao.FinnHubDao;
import org.bofus.jstock.domain.FinnHubMarketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FinnHubServiceImpl implements FinnHubService {
  @Autowired FinnHubDao dao;

  @Override
  public List<FinnHubMarketStatus> getMarketStatus(List<String> exchangeCodeList) {
    log.debug("debug point");
    return dao.getMarketStatus(exchangeCodeList);
  }
}
