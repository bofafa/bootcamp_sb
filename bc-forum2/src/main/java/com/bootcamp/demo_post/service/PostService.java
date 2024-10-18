package com.bootcamp.demo_post.service;

import java.util.List;

import com.bootcamp.demo_post.entity.PostEntity;

public interface PostService {
  List<PostEntity> saveAll(List<PostEntity> postEntities);
}

