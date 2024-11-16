package org.bofus.jstock.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.domain.ExchangeCountryCodes;
import org.bofus.jstock.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RestController
@RequestMapping("/api")
public class JstockMainController {

  @Autowired CommonService commonService;

  @GetMapping("/getExchangeCountryList")
  public List<ExchangeCountryCodes> getExchangeCountryList() {
    return commonService.getExchangeCountryList();
  }
}
