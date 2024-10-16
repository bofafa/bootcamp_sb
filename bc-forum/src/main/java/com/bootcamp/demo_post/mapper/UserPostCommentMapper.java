package com.bootcamp.demo_post.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_post.entity.CommentEntity;
import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.model.User.Address;
import com.bootcamp.demo_post.model.User.Address.Geo;
import com.bootcamp.demo_post.model.User.Company;
import com.bootcamp.demo_post.model.UserCommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.AddressDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.AddressDTO.GeoDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.CompanyDTO;

@Component
public class UserPostCommentMapper {
  public UserEntity map(User user) {
    return UserEntity.builder()
        .id(user.getId())
        .name(user.getName())//
        .username(user.getUsername())//
        .email(user.getEmail())//
        .phone(user.getPhone())//
        .website(user.getWebsite())//
        .build();
  }

  public PostEntity map(Post post) {
    return PostEntity.builder()//
        .userId(post.getUserId())//
        .id(post.getId())//
        .title(post.getTitle())//
        .body(post.getBody())//
        .build();
  }

  public CommentEntity map(Comment comment) {
    return CommentEntity.builder()//
        .id(comment.getId())//
        .email(comment.getEmail())//
        .body(comment.getBody())//
        .build();

  }

  public GeoDTO mapToDTO(GeoDTO geo) {
    return GeoDTO.builder()//
        .lat(geo.getLat())//
        .lng(geo.getLng())//
        .build();
  }

  public GeoDTO mapToDTO(Geo geo) {
    return GeoDTO.builder()//
        .lat(geo.getLat())//
        .lng(geo.getLng())//
        .build();
  }

  // public AddressDTO mapToDTO(AddressDTO address) {
  // return AddressDTO.builder()//
  // .street(address.getStreet())//
  // .suite(address.getSuite())//
  // .city(address.getCity())//
  // .zipcode(address.getZipcode())//
  // .geo(this.mapToDTO(address.getGeo()))//
  // .build();

  // }

  public AddressDTO mapToDTO(Address address) {
    return AddressDTO.builder()//
        .street(address.getStreet())//
        .suite(address.getSuite())//
        .city(address.getCity())//
        .zipcode(address.getZipcode())//
        .geo(this.mapToDTO(address.getGeo()))//
        .build();
  }

  public CompanyDTO mapToDTO(Company company) {
    return CompanyDTO.builder()//
        .name(company.getName())//
        .catchPhrase(company.getCatchPhrase())//
        .bs(company.getBs())
        .build();
  }

  public UserPostCommentDTO mapToDTO(User user) {
    return UserPostCommentDTO.builder()//
        .id(user.getId())
        .name(user.getName())//
        .username(user.getUsername())//
        .email(user.getEmail())//
        .phone(user.getPhone())//
        .website(user.getWebsite())//
        .address(mapToDTO(user.getAddress()))// type of user.getAddress() is Address , target AddressDTO
        .company(mapToDTO(user.getCompany()))
        .build();
  }

  public UserPostCommentDTO.PostDTO mapToDTO(Post post) {
    return UserPostCommentDTO.PostDTO.builder()//
        .id(post.getId())//
        .title(post.getTitle())//
        .body(post.getBody())//
        .build();
  }

  public UserPostCommentDTO.CommentDTO mapToDTO(Comment comment) {
    return UserPostCommentDTO.CommentDTO.builder()//
        .id(comment.getId())//
        .name(comment.getName())//
        .email(comment.getEmail())//
        .body(comment.getBody())//
        .build();
  }

  public UserCommentDTO.CommentDTO map(UserPostCommentDTO.CommentDTO comment) {
    return UserCommentDTO.CommentDTO.builder()//
        .name(comment.getName())//
        .body(comment.getBody())//
        .email(comment.getEmail())
        .build();
  }
}
