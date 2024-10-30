package com.bootcamp.demo.demo_sb_restapi.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
  List<UserEntity> getAll() throws JsonProcessingException;
}
