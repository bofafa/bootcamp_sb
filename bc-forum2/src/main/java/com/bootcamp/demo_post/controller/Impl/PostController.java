package com.bootcamp.demo_post.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_post.controller.PostControllerOperation;
import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.service.JPHCommentService;
import com.bootcamp.demo_post.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class PostController implements PostControllerOperation  {
  
@Autowired
private JPHCommentService jphCommentService;

@Autowired
private PostService postService;

@Override
public  List<User> getUser(){
    return this.jphCommentService.getUser();
}

@Override
public  List<Post> getPost()throws JsonProcessingException{
    return this.jphCommentService.getPost();
}

@Override
public  List<Post> getAll()throws JsonProcessingException{
    return this.jphCommentService.getAll();
}


@Override
public List <Comment> getComment(){
    return this.jphCommentService.getComment();
}
    
@Override
public List<PostEntity> findPostByTitle(@PathVariable String title) {
    List<PostEntity> postEntity = postService.findPostByTitle(title);
    if (postEntity != null) {
        return postEntity;
    } else {
      
        throw new EntityNotFoundException("Post with title '" + title + "' not found");
    }
  }


}
