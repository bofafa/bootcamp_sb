package com.bootcamp.demo_post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_post.model.User;

public interface UserOperation {

  @GetMapping("/jph/getDataFromDatabase")
  List<User> getAllDataFromDatabase();
}
