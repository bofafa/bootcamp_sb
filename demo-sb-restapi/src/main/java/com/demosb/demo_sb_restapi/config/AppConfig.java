package com.demosb.demo_sb_restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.demosb.demo_sb_restapi.model.Cat;
import com.demosb.demo_sb_restapi.model.Color;

// Component Scan -> @Controller, @Service, @Configuration
// ! @Cofiguration + @Bean 
@Configuration // ! usually we use configuration + bean, when we use exrernal library/class --- 3rd party datat
public class AppConfig {  // bean
  @Bean(name = "JPHRestTemplate")
  RestTemplate restTemplateForJPH() {
    return new RestTemplate();
  }

  @Bean(name = "ABCRestTemplate")
  RestTemplate restTemplateForABC() {
    return new RestTemplate();
  }

  @Bean
  Cat cat() {
    return new Cat("Vincent", 20, Color.BLUE, 3.0);
  }
  
  // Beans ...
}
