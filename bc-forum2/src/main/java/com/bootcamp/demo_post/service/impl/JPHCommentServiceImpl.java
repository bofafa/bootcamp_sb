package com.bootcamp.demo_post.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_post.entity.AddressEntity;
import com.bootcamp.demo_post.entity.CompanyEntity;
import com.bootcamp.demo_post.entity.GeoEntity;
import com.bootcamp.demo_post.exception.ErrorCode;
import com.bootcamp.demo_post.exception.JPHRestClientException;
import com.bootcamp.demo_post.mapper.JPHCommentMapper;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.model.UserPostCommentDTO.AddressDTO.GeoDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.CompanyDTO;
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
  // }

  @Override
  public List<User> getUser() {
    String url = Url.builder()
        .scheme(Scheme.HTTPS)
        .domain(this.jphDomain)
        .endpoint(this.usersEndpoint)
        .build()
        .toUriString();
    System.out.println("url=" + url);
    User[] users;
    try {
      users = this.restTemplate.getForObject(url, User[].class);
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
    Comment[] comments;
    comments = this.restTemplate.getForObject(url, Comment[].class);
    if (!ResponseEntity.ofNullable(comments).getStatusCode().is2xxSuccessful())
      throw new JPHRestClientException(ErrorCode.RESST_TEMPLAT_ERROR.getMessage());
    return List.of(comments);
  }

  @Override
  public List<AddressEntity> getAddressEntity() {
    return getUser().stream().map(user -> {
      AddressEntity addressEntity = AddressEntity.builder()//
          .id(user.getId())//
          .addrStreet(user.getAddress().getStreet())//
          .addrSuite(user.getAddress().getSuite())//
          .addrCity(user.getAddress().getCity())
          .addrZipcode(user.getAddress().getZipcode())
          .build();
      return addressEntity;
    })//
        .collect(Collectors.toList());
  }


  @Override
  public List<CompanyEntity> getCompanyEntity() {
    return getUser().stream().map(user -> {
      CompanyEntity companyEntity = CompanyEntity.builder()//
          .id(user.getId())//
          .name(user.getCompany().getName())//
          .catchPhrase(user.getCompany().getCatchPhrase())//
          .bs(user.getCompany().getBs())
          .build();
      return companyEntity;
    })//
        .collect(Collectors.toList());
  }


  @Override
  public List<GeoEntity> getGeoEntity() {
    return getUser().stream().map(user -> {
      GeoEntity geoEntity = GeoEntity.builder()//
          .id(user.getId())
          .lat(user.getAddress().getGeo().getLat())
          .lng(user.getAddress().getGeo().getLng())
          .build();
      return geoEntity;
    })//
        .collect(Collectors.toList());
  }

 

  // @Override
  // public List<CompanyDTO> getCompanyDTO() {
  //   return null;
  // }



  // getUserPostCommentDTO

}
