package com.bootcamp.demo_post.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_post.entity.CommentEntity;
import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.entity.UserPostCommentEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.model.UserPostCommentDTO;

@Component
public class JPHCommentMapper {


   public UserEntity map(User user) {
    return UserEntity.builder() //
        .id(user.getId())
        .name(user.getName())
        .username(user.getUsername())
        .name(user.getName()) //
        .username(user.getUsername()) //
        .phone(user.getPhone()) //
        .website(user.getWebsite()) //
        .build();
  }


  public PostEntity map(Post post) {
    return PostEntity.builder() 
        //.userId(post.getUserId())
       .id(post.getId())
       .title(post.getTitle())
       .body(post.getBody())
       .build();
  }

  public CommentEntity map(Comment comment) {
    return CommentEntity.builder() 
    //.postId(comment.getPostId())
    .id(comment.getId())
    .name(comment.getName())
    .email(comment.getEmail())
    .body(comment.getBody())
       .build();
  }
}

