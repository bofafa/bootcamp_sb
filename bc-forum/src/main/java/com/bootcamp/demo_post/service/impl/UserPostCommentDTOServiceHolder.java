package com.bootcamp.demo_post.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_post.mapper.UserPostCommentMapper;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.model.UserPostCommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.CommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO.PostDTO;
import com.bootcamp.demo_post.service.JPHCommentService;
import com.bootcamp.demo_post.service.UserPostCommentDTOService;

@Service
public class UserPostCommentDTOServiceHolder implements UserPostCommentDTOService {

  @Autowired
  @Qualifier(value = "JPHRestTemplate")
  private RestTemplate restTemplate;

  @Autowired
  private UserPostCommentMapper userPostCommentMapper;

  @Autowired
  private JPHCommentService jphCommentService;

  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Value("${api.jph.endpoints.posts}")
  private String postsEndpoint;

  @Value("${api.jph.endpoints.comments}")
  private String commentsEndpoint;

  @Override
  public List<UserPostCommentDTO> getUserPostCommentDTO() {
    List<User> userList = this.jphCommentService.getUser();
    List<Post> postList = this.jphCommentService.getPost();
    List<Comment> commentList = this.jphCommentService.getComment();

    // Create UserPostCommentDTO list
    List<UserPostCommentDTO> userPostCommentDTOList = userList.stream().map(user -> {
  
      List<PostDTO> postDTOs = postList.stream()
          .filter(post -> post.getUserId().equals(user.getId()))  //對ID, 同名放入List
          .map(post -> {
            List<UserPostCommentDTO.CommentDTO> commentDTOs = commentList.stream()//
                .filter(comment -> comment.getPostId().equals(post.getUserId()))//
                .map(comment -> userPostCommentMapper.mapToDTO(comment))
                .collect(Collectors.toList());

            // Create PostDTO and add comments
            PostDTO postDTO = userPostCommentMapper.mapToDTO(post);
            postDTO.setCommentDTO(commentDTOs);
            return postDTO;
          })
          .collect(Collectors.toList());

      // Map user details and add posts
      UserPostCommentDTO userPostCommentDTO = userPostCommentMapper.mapToDTO(user);
      userPostCommentDTO.setPostDTO(postDTOs);

      return userPostCommentDTO;
    }).collect(Collectors.toList());

    return userPostCommentDTOList;
  }

}
