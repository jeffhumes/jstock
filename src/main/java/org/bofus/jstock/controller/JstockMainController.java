package org.bofus.jstock.controller;

import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.config.FinnHubConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RestController
@RequestMapping("/api")
public class JstockMainController {

  @Autowired FinnHubConfig finnHubConfig;

  // @GetMapping("/getStringFromDatabase")
  // public List<StringBean> getStringFromDatabase() {
  // log.debug(finnHubConfig.getBaseUrl());
  // log.debug(finnHubConfig.getApiKey());
  // log.debug(finnHubConfig.getCompany_financials_endpoint());
  // log.debug("Entering GetMapping: /getStringFromDatabase");
  // List<StringBean> returnValue = null;
  // return returnValue;
  // }
}
