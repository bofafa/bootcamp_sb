package com.bootcamp.demo_post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.service.PostService;
import com.bootcamp.demo_post.userRepository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Override
  public List<PostEntity> saveAll(List<PostEntity> postEntities) {
    return postRepository.saveAll(postEntities);
  }
}