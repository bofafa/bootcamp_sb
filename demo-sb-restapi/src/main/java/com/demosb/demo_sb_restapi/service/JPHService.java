package com.demosb.demo_sb_restapi.service;

import java.util.List;

import com.demosb.demo_sb_restapi.dto.UserDTO;
import com.demosb.demo_sb_restapi.entity.UserEntity;

// https://jsonplaceholder.typicode.com/
public interface JPHService {
  List<UserDTO> getUsers();
  List<UserEntity> saveUsers();
}