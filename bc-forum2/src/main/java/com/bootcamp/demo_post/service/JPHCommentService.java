package com.bootcamp.demo_post.service;

import java.util.List;

import com.bootcamp.demo_post.entity.AddressEntity;
import com.bootcamp.demo_post.entity.CompanyEntity;
import com.bootcamp.demo_post.entity.GeoEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.model.User.Address;
import com.bootcamp.demo_post.model.UserPostCommentDTO.AddressDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.CompanyDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.AddressDTO.GeoDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO;

public interface JPHCommentService {


List<User> getUser();
List<Post> getPost();
List<Comment> getComment();
List<AddressEntity> getAddressEntity();
List<CompanyEntity> getCompanyEntity();
List<GeoEntity> getGeoEntity();


}
