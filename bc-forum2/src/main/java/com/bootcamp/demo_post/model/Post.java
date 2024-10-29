package com.bootcamp.demo_post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class Post {
  private Integer userId;
  private Integer id;
  private String title;
  private String body;

}
