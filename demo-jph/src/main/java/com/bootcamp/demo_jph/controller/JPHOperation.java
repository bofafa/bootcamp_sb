package com.bootcamp.demo_jph.controller;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.demo_jph.dto.UserDTO;
import com.bootcamp.demo_jph.entity.UserEntity;




public interface JPHOperation {
  @GetMapping("/jph/users")
  List<UserDTO> getUsers();


@PostMapping ("/jph/users")
List<UserEntity> createUsers();

@PostMapping ("/jph/saveusers")
List<UserEntity> saveUsers();
}