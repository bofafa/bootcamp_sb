package com.bootcamp.demo.demo_sb_restapi.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_sb_restapi.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostService {
  List<PostEntity> saveAll(List<PostEntity> postEntities);

  List<Post> getAll() throws JsonProcessingException;
}
