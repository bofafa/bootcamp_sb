package com.bootcamp.demo.demo_sb_restapi.model.dto.jph;

import lombok.Getter;

@Getter
public class CommentDTO {
  private Long id;
  private Long postId;
  private String body;
  private String email;
  private String name;
}
