package com.example.apihandin2.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class demoController {

  private final int SLEEP_TIME = 1000*3;
/*
  @GetMapping(value = "/random-string-slow")
  public String slowEndpoint() throws InterruptedException {
    Thread.sleep(SLEEP_TIME);
    return RandomStringUtils.randomAlphanumeric(10);
  }

 */

}
