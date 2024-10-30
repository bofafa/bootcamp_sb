package com.bootcamp.demo.demo_sb_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Post {
  private Long id;
  private String title;
  private String body;
}
