package com.bootcamp.demo_post.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@Setter
public class UserPostCommentDTO {
  private Integer id;
  private String name;
  private String username;
  String email;
  AddressDTO address;
  String phone;
  String website;
  CompanyDTO company;

  @Builder.Default      //要new 嘢入去個list 要用  @Builder.Default   
  List<PostDTO> postDTO = new ArrayList<>();

  @Getter
  @Builder
  @ToString
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    @Getter
    @Builder
    @ToString
    public static class GeoDTO {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @Builder
  @ToString
  public static class CompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }

  @Data
  @Builder
  public static class PostDTO {
    private Integer id;
    private String title;
    private String body;

    @Builder.Default    
    private List<CommentDTO> commentDTO = new ArrayList<>();

  }

  @Data
  @Builder
  public static class CommentDTO {
    private Integer id;
    private String name;
    private String email;
    private String body;

  }
}