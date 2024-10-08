package com.bootcamp.demo_jph.service;

import java.util.List;

import com.bootcamp.demo_jph.dto.UserDTO;
import com.bootcamp.demo_jph.entity.UserEntity;



// https://jsonplaceholder.typicode.com/
public interface JPHService {
  List<UserDTO> getUsers();
  List<UserEntity> saveUsers();
}