package com.bootcamp.demo_jph.service;

import java.util.List;

import com.bootcamp.demo_jph.dto.user;
import com.bootcamp.demo_jph.entity.UserEntity;



// https://jsonplaceholder.typicode.com/
public interface JPHService {

  List<user> getUsers();
  
  // call API
  List<UserEntity> saveUsers();
  
  UserEntity createUser(UserEntity userEntity);

  Boolean deleteUser(Long id);

  UserEntity updateUser(Long id, UserEntity entity);

  UserEntity patchUserWebsite(Long id, String website);
}