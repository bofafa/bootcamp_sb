package com.bootcamp.demo.demo_sb_restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication // @ComponentScan + @SpringBootConfiguration + @EnableAutoConfiguration
// ! @ComponentScan
  // ! 1. Bean (Object)
    // - Something like object, but NOT created by your writtien class
    // - Unique
  // ! 2. Spring Context
    // - Separated memory area, besides heap memory
    // - Store beans
  // ! 3. Spring life cycle
    // jar -> mvn spring-boot:run
    // - Before Server start, look up which class is being annotated as component
      // i.e. @Controller, @Service are components, so Spring will create an object for this class
// @SpringBootConfiguration
// @EnableAutoConfiguration
// ! IoC (Inversion of Control)
@EnableScheduling
public class DemoSbRestapiApplication {
  public static ConfigurableApplicationContext context;
  public static void main(String[] args) {
    context = SpringApplication.run(DemoSbRestapiApplication.class, args); // 7 x 24
  }

}
