package com.bootcamp.demo_post.service.impl;

import java.util.List;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_post.exception.JPHRestClientException;
import com.bootcamp.demo_post.mapper.JPHCommentMapper;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.user;
import com.bootcamp.demo_post.model.UserPostCommentDTO;
import com.bootcamp.demo_post.service.JPHCommentService;
// import com.bootcamp.demo_post.userRepository.UserRepository;
import com.bootcamp.demo_post.util.Scheme;
import com.bootcamp.demo_post.util.Url;

@Service
public class JPHCommentServiceImpl implements JPHCommentService {
  @Autowired
  @Qualifier(value = "JPHRestTemplate")
  private RestTemplate restTemplate;

  // @Autowired
  // private UserRepository userRepository;

  @Autowired
  private JPHCommentMapper jphCommentMapper;

  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Value("${api.jph.endpoints.posts}")
  private String postsEndpoint;

  @Value("${api.jph.endpoints.comments}")
  private String commentsEndpoint;

  // @Override
  // public List<UserPostCommentDTO> getUserPostComment() {
  // String url= Url.builder()
  // .scheme(Scheme.HTTPS)
  // .domain(this.jphDomain)
  // .endpoint(this.usersEndpoint)
  // .build()
  // .toUriString();
  // System.out.println("url=" + url);
  // user[] users;
  // try{
  // users = this.restTemplate.getForObject(url,user[].class);
  // } catch(RestClientException e){
  // throw new JPHRestClientException("joson Placeholder exception.");
  // }
  // return List.of(userPostComment);
  //}

  @Override
  public List<user> getUser() {
    String url = Url.builder()
        .scheme(Scheme.HTTPS)
        .domain(this.jphDomain)
        .endpoint(this.usersEndpoint)
        .build()
        .toUriString();
    System.out.println("url=" + url);
    user[] users;
    try {
      users = this.restTemplate.getForObject(url, user[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("joson Placeholder exception.");
    }
    return List.of(users);
  }

  @Override
  public List<Post> getPost() {
    String url = Url.builder()
        .scheme(Scheme.HTTPS)
        .domain(this.jphDomain)
        .endpoint(this.postsEndpoint)
        .build()
        .toUriString();
    System.out.println("url=" + url);
    Post[] posts;
    try {
      posts = this.restTemplate.getForObject(url, Post[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("joson Placeholder exception.");
    }
    return List.of(posts);
  }

  @Override
  public List<Comment> getComment() {
    String url = Url.builder()
        .scheme(Scheme.HTTPS)
        .domain(this.jphDomain)
        .endpoint(this.commentsEndpoint)
        .build()
        .toUriString();
    System.out.println("url=" + url);
    Comment[] comments;
    try {
      comments = this.restTemplate.getForObject(url, Comment[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("joson Placeholder exception.");
    }
    return List.of(comments);
  }

  getUserPostCommentDTO 


}
