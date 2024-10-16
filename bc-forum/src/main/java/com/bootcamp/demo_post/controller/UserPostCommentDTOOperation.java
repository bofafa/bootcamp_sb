package com.bootcamp.demo_post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_post.model.UserCommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO;

public interface UserPostCommentDTOOperation {
 @GetMapping("/jph/userpostcomments")
  List<UserPostCommentDTO> getUserPostCommentDTO();

  @GetMapping("/jph/exercise3A")
  UserCommentDTO exercise3A(@RequestParam String userID);

}
