package com.bootcamp.demo_jph.config;


  import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


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

 
  }
  
  // Beans ...

