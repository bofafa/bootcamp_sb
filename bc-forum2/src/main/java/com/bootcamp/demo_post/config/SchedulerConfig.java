package com.bootcamp.demo_post.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Configuration
@Component
public class SchedulerConfig {

  //!Afer task compeleted, count 6 seconds
  @Scheduled(fixedDelay = 6000)
  public void sayHello() throws Exception{ 
    System.out.println("Task A start, time = " + System.currentTimeMillis());
    Thread.sleep(4000);
    System.out.println("Task A end, time = " + System.currentTimeMillis());
  }

  //! every 3 second to exceute
  @Scheduled(fixedRate = 5000)
  public void sayBye() throws Exception{
    System.out.println("Task B start, time = " + System.currentTimeMillis());
    Thread.sleep(3000);
    System.out.println("Task B end, time = " + System.currentTimeMillis());
  }
}
