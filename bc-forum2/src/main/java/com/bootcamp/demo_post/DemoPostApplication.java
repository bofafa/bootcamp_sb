package com.bootcamp.demo_post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPostApplication.class, args);
	}

}
