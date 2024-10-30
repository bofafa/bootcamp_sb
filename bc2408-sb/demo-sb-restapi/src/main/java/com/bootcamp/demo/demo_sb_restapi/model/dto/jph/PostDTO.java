package com.bootcamp.demo.demo_sb_restapi.model.dto.jph;

import lombok.Getter;

@Getter
public class PostDTO {
  private Long id;
  private Long userId;
  private String title;
  private String body;
}
