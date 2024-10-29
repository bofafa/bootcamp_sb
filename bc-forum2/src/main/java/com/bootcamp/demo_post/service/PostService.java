package com.bootcamp.demo_post.service;

import java.util.List;

import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostService {
  List<PostEntity> saveAll(List<PostEntity> postEntities);

  List<PostEntity> findPostByTitle(String title);


 List<Post> getALL() throws JsonProcessingException; //for redis
}

