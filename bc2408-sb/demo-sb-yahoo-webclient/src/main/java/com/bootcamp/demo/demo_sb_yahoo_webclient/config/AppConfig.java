package com.bootcamp.demo.demo_sb_yahoo_webclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_sb_yahoo_webclient.infra.yahoo.CookieManager;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  CookieManager cookieManager(RestTemplate restTemplate) {
    return new CookieManager(restTemplate);
  }
}
