package com.bootcamp.demo.demo_sb_restapi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {
  // Threading per method

  // ! After task completed, count 6 seconds ...
  // @Scheduled(fixedDelay = 60000)
  public void sayHello() throws Exception {
    System.out.println("Task A Starts. time=" + System.currentTimeMillis());
    Thread.sleep(4000);
    System.out.println("Task A Ends. time=" + System.currentTimeMillis());
  }

  // ! Every 3 seconds to exceute
  // @Scheduled(fixedRate = 3000)
  public void sayBye() throws Exception {
    System.out.println("Task B Starts. time=" + System.currentTimeMillis());
    Thread.sleep(2000);
    System.out.println("Task B Ends. time=" + System.currentTimeMillis());
  }
}
