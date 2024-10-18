package com.bootcamp.demo_post.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.model.UserCommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO;

@Component
public class UserCommentMapper {
   public UserEntity map (User user){
  return UserEntity.builder()
  .id(user.getId())
  .name(user.getName())
  .build();//
}


public UserCommentDTO.CommentDTO mapTODTO(Comment comment){
    return UserCommentDTO.CommentDTO.builder()//
       .id(comment.getId())//
      .name(comment.getName())//
      .email(comment.getEmail())//
      .body(comment.getBody())//
      .build();
}
}