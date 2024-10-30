package com.bootcamp.demo.demo_sb_restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // mvn clean test -> server start
// ! Full Spring Environment (Full beans)
class DemoSbRestapiApplicationTests {

  @Test // server start -> create context
  void contextLoads() {
    // This test case is just for server start + bean dependency validations
    // i.e @Autowired (required bean), @Value (yml)
  }

}
