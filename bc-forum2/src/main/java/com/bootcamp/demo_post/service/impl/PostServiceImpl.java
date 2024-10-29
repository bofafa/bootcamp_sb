package com.bootcamp.demo_post.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.mapper.JPHCommentMapper;
import com.bootcamp.demo_post.mapper.UserPostCommentMapper;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.service.PostService;
import com.bootcamp.demo_post.userRepository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

 
  @Autowired
  private JPHCommentMapper jPHCommentMapper;


  @Override
  public List<PostEntity> saveAll(List<PostEntity> postEntities) {
    return postRepository.saveAll(postEntities);
  }

  @Override
  public List<PostEntity> findPostByTitle(String title) {
    return postRepository.findPostEntity(title);
 }


  @Override
  public List <Post> getALL() throws JsonProcessingException {
  return postRepository.findAll().stream()//
  .map(postEntity -> jPHCommentMapper.map(postEntity))//
  .collect(Collectors.toList());
  
  }


 
}