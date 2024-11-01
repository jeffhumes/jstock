package org.bofus.jstock.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bofus.jstock.domain.StringBean;
import org.bofus.jstock.service.StringService;
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

  @Autowired StringService stringService;

  @GetMapping("/getString")
  public String returnString() {
    log.debug("Entering GetMapping: /getString");
    String returnValue = null;
    returnValue = "The Quick Brown Fox Jumped Over The Lazy Dog's Back";
    log.debug(String.format("returning String: %s", returnValue));
    return returnValue;
  }

  @GetMapping("/getStringFromDatabase")
  public List<StringBean> getStringFromDatabase() {
    log.debug("Entering GetMapping: /getStringFromDatabase");
    List<StringBean> returnValue = null;
    returnValue = stringService.getStringBeanList();
    return returnValue;
  }
}
