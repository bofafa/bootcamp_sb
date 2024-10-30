package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restapi.controller.PostOperation;
import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_sb_restapi.model.Post;
import com.bootcamp.demo.demo_sb_restapi.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class PostController implements PostOperation {
  @Autowired
  private PostService postService;
  
  @Override
  public List<Post> getPosts() throws JsonProcessingException {
    return this.postService.getAll();
  }
}
