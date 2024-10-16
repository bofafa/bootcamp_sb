package com.bootcamp.demo_post.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_post.model.UserCommentDTO;

public interface UserCommerntDTOOperation {
  
  @GetMapping("/jph/usercomments")
  UserCommentDTO getUserCommentDTO(String userID);
}
