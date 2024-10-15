package com.demosb.demo_sb_restapi.controller.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.demosb.demo_sb_restapi.controller.JPHOperation;
import com.demosb.demo_sb_restapi.dto.user;
import com.demosb.demo_sb_restapi.entity.UserEntity;
import com.demosb.demo_sb_restapi.service.JPHService;
import com.demosb.demo_sb_restapi.service.impl.JPHServiceImpl;

// A new Thread
  // JPHController c = get bean from Context
  @RestController
  public class JPHController implements JPHOperation {
    private static String x = "abc";
    // Controller Layer -> Service Layer
    // ! Autowired (Bean Injection - from Spring Context)
      // Before Server start:
        // Spring check if there is a bean from Spring Context can be injected into this object reference
        // What if not found ? Server start fail ....
      // After Server start:
        // API request comes... jphController Bean calls jphService Bean
      // @Autowired(required = false)
        // If the bean not found, still proceed server starts ...
    @Autowired
    private JPHService jphService; // Interface
    // Animal animal = new Cat();
  
  
    @Override
    public List<user> getUsers() {
      return this.jphService.getUsers();
    }
  
    @Override
    public List<UserEntity> createUsers() {
      return this.jphService.saveUsers();


    }



    @Override
    public List<UserEntity> saveUsers() {
    return this.jphService.saveUsers();
    }
  }
  