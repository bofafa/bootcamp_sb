package com.bootcamp.demo_jph;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//呢度test 整個JPH start

@SpringBootTest // mvn clean test ->  server start
//! full Spring enviroment (Full beans)
//develper -> dont want run time dead, should be mvn spring test

class DemoJphApplicationTests {
 
	@Test // server start-> create context
	void contextLoads() { // this tesst case is just for server start + beana dependency validations
		// i.e @Autowired (reqired bean), @value (yml)
	}

}
