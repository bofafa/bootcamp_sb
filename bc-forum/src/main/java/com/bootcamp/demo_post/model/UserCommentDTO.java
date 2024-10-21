package com.bootcamp.demo_post.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCommentDTO {
  private Integer id;
  private String name;
  List<CommentDTO> commentDTOs = new ArrayList<>();

  @Data
  @Builder
  public static class CommentDTO {
    private Integer id;
    private String name;
    private String email;
    private String body;

  }
}