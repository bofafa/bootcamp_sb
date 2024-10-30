package com.bootcamp.demo.demo_sb_yahoo_webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_yahoo_webclient.infra.yahoo.CookieManager;


@RestController
public class YahooFinanceController {
  @Autowired
  private CookieManager cookieManager;

  @GetMapping("/test/cookie")
  public String test() {
    return this.cookieManager.getCookie();
  }

}
