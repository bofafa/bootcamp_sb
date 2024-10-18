package com.bootcamp.demo_post.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_post.controller.UserPostCommentDTOOperation;
import com.bootcamp.demo_post.model.UserCommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO;
import com.bootcamp.demo_post.service.UserCommentDTOService;
import com.bootcamp.demo_post.service.UserPostCommentDTOService;

@RestController
public class UserPostCommentDTOController implements UserPostCommentDTOOperation {

  @Autowired
  private UserPostCommentDTOService userPostCommentDTOService;

  @Autowired
  private UserCommentDTOService userCommentDTOService;

  @Override
  public List<UserPostCommentDTO> getUserPostCommentDTO() {
    return this.userPostCommentDTOService.getUserPostCommentDTO();
  }

  @Override
  public UserCommentDTO exercise3A(String userID) {
    return userCommentDTOService.getUserCommentDTO(userID);
  }
}
