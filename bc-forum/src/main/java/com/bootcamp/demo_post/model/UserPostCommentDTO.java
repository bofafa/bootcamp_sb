package com.bootcamp.demo_post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserPostCommentDTO{

    private int id;
    private String name;
    private String username;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Address {
      private String street;
      private String suite;
      private String city;
      private String zipcode;
      private Geo geo;

      @AllArgsConstructor
@NoArgsConstructor
@Getter
      public static class Geo {
        private String lat;
        private String lng;
      }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Company {
      private String name;
      private String catchPhrase;
      private String bs;
    }
  
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
  public static class PostDTO { 
    private int userId;
    private int id;
    private String title;
    private String body;
 

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
  public static class CommentDTO { 
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
  }
  }
}

            