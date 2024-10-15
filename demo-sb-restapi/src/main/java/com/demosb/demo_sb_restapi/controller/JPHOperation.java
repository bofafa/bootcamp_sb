package com.demosb.demo_sb_restapi.controller;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demosb.demo_sb_restapi.dto.user;
import com.demosb.demo_sb_restapi.entity.UserEntity;

public interface JPHOperation {
  @GetMapping("/jph/users")
  List<user> getUsers();


@PostMapping ("/jph/users")
List<UserEntity> createUsers();

@PostMapping ("/jph/users")
List<UserEntity> saveUsers();
}