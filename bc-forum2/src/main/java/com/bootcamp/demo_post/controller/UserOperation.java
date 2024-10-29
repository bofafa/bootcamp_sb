package com.bootcamp.demo_post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserOperation {

  @GetMapping("/jph/getDataFromDatabase")
  List<User> getAllDataFromDatabase()  throws JsonProcessingException ;

  @GetMapping("/jph/getUserByID/{userID}")
  List<UserEntity> getUserByID(@PathVariable String userID);
}
