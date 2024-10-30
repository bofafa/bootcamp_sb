package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_sb_restapi.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostOperation {
  @GetMapping("/db/posts")
  List<Post> getPosts() throws JsonProcessingException;
}