package com.bootcamp.demo_post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;

public interface PostControllerOperation {

  // @GetMapping("/jph/userspost")
  // List<UserPostCommentDTO> getUserPostComment();


  @GetMapping("/jph/users")
  List<User> getUser();


  @GetMapping("/jph/posts")
  List<Post> getPost();


  @GetMapping("/jph/comments")
  List<Comment> getComment();
}
