package com.bootcamp.demo_post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;

public interface PostControllerOperation {



  @GetMapping("/jph/users")
  List<User> getUser();


  @GetMapping("/jph/posts/{title}")
  List<PostEntity> findPostByTitle(String title);


  @GetMapping("/jph/posts")
  List<Post> getPost();


  @GetMapping("/jph/comments")
  List<Comment> getComment();
}
