package com.bootcamp.demo_post.controller.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_post.controller.UserOperation;
import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  public List<User> getAllDataFromDatabase() throws JsonProcessingException {
    return userService.getAllDataFromDatabase().stream()//
        .map(user -> this.map(user))//
        .collect(Collectors.toList());
       
  }

  private User map(UserEntity userEntity) {
    return User.builder()//
        .id(userEntity.getId())//
        .name(userEntity.getName())//
        .build();
  }

  @Override
  public List<UserEntity> getUserByID(String userID) {
    return userService.getUserByID(Integer.parseInt(userID));
  }
}