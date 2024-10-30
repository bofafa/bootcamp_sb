package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserOperation {
  @GetMapping("/db/users")
  List<UserEntity> getUsers() throws JsonProcessingException;
}
