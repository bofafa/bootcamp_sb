package com.bootcamp.demo_post.model;

import lombok.Getter;

@Getter
public class Comment {
  private Integer postId;
  private Integer id;
  private String name;
  private String email;
  private String body;
  
}
