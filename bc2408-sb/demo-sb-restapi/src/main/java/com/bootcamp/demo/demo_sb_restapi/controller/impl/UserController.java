package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restapi.controller.UserOperation;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;
  
  @Override
  public List<UserEntity> getUsers() throws JsonProcessingException {
    return this.userService.getAll();
  }
}
