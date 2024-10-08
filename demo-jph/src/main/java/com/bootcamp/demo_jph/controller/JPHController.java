package com.bootcamp.demo_jph.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_jph.dto.UserDTO;
import com.bootcamp.demo_jph.entity.UserEntity;
import com.bootcamp.demo_jph.service.JPHService;


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
    public List<UserDTO> getUsers() {
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
  
