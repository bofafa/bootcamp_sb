package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.mapper.PostMapper;
import com.bootcamp.demo.demo_sb_restapi.model.Post;
import com.bootcamp.demo.demo_sb_restapi.repository.PostRepository;
import com.bootcamp.demo.demo_sb_restapi.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private PostMapper postMapper;

  @Override
  public List<PostEntity> saveAll(List<PostEntity> postEntities) {
    return postRepository.saveAll(postEntities);
  }

  @Override
  public List<Post> getAll() throws JsonProcessingException {
    // if redis key exists, get the value (json string)
    String json = this.redisTemplate.opsForValue().get("jph-posts");
    if (json == null) {
      System.out.println("Redis not found.");
      // read from DB
      List<PostEntity> postEntities = postRepository.findAll();
      List<Post> posts = postEntities.stream() //
          .map(e -> this.postMapper.map(e)) //
          .collect(Collectors.toList());
      // write to Redis ...
      String dbJsonString = this.objectMapper.writeValueAsString(posts);
      this.redisTemplate.opsForValue().set("jph-posts", dbJsonString,
          Duration.ofMinutes(10));
      return posts;
    }
    return Arrays.asList(this.objectMapper.readValue(json, PostEntity[].class))
        .stream() //
        .map(e -> this.postMapper.map(e)) //
        .collect(Collectors.toList());
  }
}

