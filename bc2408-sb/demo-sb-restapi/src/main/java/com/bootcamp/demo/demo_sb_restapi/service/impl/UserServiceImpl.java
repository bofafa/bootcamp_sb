package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_sb_restapi.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  // ! Inside getForObject() uses ObjectMapper.class
  // ! In Spring, the framework always use ObjectMapper for serialization/
  // deserialization
  // xxx object = this.restTemplate.getForObject(url, xxx.class);

  @Override
  public List<UserEntity> getAll() throws JsonProcessingException {
    // if redis key exists, get the value (json string)
    String json = this.redisTemplate.opsForValue().get("jph-users");
    if (json == null) {
      // read from DB
      List<UserEntity> userEntities = userRepository.findAll();
      // write to Redis ...
      String dbJsonString = this.objectMapper.writeValueAsString(userEntities);
      this.redisTemplate.opsForValue().set("jph-users", dbJsonString);
      return userEntities;
    }
    return Arrays.asList(this.objectMapper.readValue(json, UserEntity[].class));
  }
}
