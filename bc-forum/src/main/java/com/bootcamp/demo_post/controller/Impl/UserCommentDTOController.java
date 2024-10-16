package com.bootcamp.demo_post.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_post.controller.UserCommerntDTOOperation;
import com.bootcamp.demo_post.model.UserCommentDTO;
import com.bootcamp.demo_post.service.UserCommentDTOService;


@RestController
public class UserCommentDTOController implements UserCommerntDTOOperation {
  
    @Autowired
  private UserCommentDTOService  userCommentDTOService;

  @Override
  public UserCommentDTO getUserCommentDTO(String userID) {
    return this.userCommentDTOService.getUserCommentDTO(userID);
  }
}
