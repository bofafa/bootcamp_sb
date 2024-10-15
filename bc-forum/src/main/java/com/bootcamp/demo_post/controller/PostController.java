package com.bootcamp.demo_post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.service.JPHCommentService;

@RestController
public class PostController implements PostControllerOperation  {
  
@Autowired
private JPHCommentService jphCommentService;


@Override
public  List<User> getUser(){
    return this.jphCommentService.getUser();
}

@Override
public  List<Post> getPost(){
    return this.jphCommentService.getPost();
}

@Override
public List <Comment> getComment(){
    return this.jphCommentService.getComment();
}
}