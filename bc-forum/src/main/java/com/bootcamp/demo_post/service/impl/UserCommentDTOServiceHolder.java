package com.bootcamp.demo_post.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_post.exception.ErrorCode;
import com.bootcamp.demo_post.exception.InvalidInputException;
import com.bootcamp.demo_post.exception.RestTemplateException;
import com.bootcamp.demo_post.exception.UserNotFoundException;
import com.bootcamp.demo_post.mapper.UserCommentMapper;
import com.bootcamp.demo_post.mapper.UserPostCommentMapper;
import com.bootcamp.demo_post.model.UserCommentDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO;
import com.bootcamp.demo_post.service.JPHCommentService;
import com.bootcamp.demo_post.service.UserCommentDTOService;
import com.bootcamp.demo_post.service.UserPostCommentDTOService;

@Service
public class UserCommentDTOServiceHolder implements UserCommentDTOService {

  @Autowired
  @Qualifier(value = "JPHRestTemplate")
  private RestTemplate restTemplate;

  @Autowired
  private UserCommentMapper userCommentMapper;

  @Autowired
  private JPHCommentService jphCommentService;

  @Autowired
  private UserPostCommentDTOService userPostCommentDTOService;

  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Value("${api.jph.endpoints.posts}")
  private String postsEndpoint;

  @Value("${api.jph.endpoints.comments}")
  private String commentsEndpoint;

  @Autowired
  private UserPostCommentMapper userPostCommentMapper;

  @Override
  public UserCommentDTO getUserCommentDTO(String userID) {
    Integer convertUserID = Integer.parseInt(userID);
    List<UserPostCommentDTO> allList = userPostCommentDTOService.getUserPostCommentDTO();
    UserCommentDTO result = new UserCommentDTO();
    
    // Find the user by ID using stream
    UserPostCommentDTO targetUser = allList.stream()
        .filter(user -> convertUserID.equals(user.getId()))
        .findFirst()
        .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    
    // Collect all comments from all posts using stream
    List<UserCommentDTO.CommentDTO> insideList = targetUser.getPostDTO().stream()
        .flatMap(post -> post.getCommentDTO().stream())  // Flatten the comments from all posts 
        .map(comment -> userPostCommentMapper.map(comment))  // Map each comment to UserCommentDTO.CommentDTO
        .collect(Collectors.toList());
    
    // Set result data
    result.setId(convertUserID);
    result.setName(targetUser.getName());
    result.setCommentDTOs(insideList);
    
    return result;

}


// [[1,2,3],[4,5,6]] -> flatmap -> [1,2,3,4,5,6]
// [[1,2,3],[4,5,6]] -> map -> [[1,2,3,4,5,6]]


    // List<UserCommentDTO.CommentDTO> insideList = new ArrayList<>();

    // UserPostCommentDTO targetUser = allList.stream()//
    //     .filter(user -> convertUserID.equals(user.getId()))//
    //     .findFirst()//
    //     .get();


        // List<UserCommentDTO.CommentDTO> insideList = targetUser.getPostDTO().stream()
        // .flatMap(post -> post.getCommentDTO().stream())  // Flatten the comments from all posts
        // .map(comment -> userPostCommentMapper.map(comment))  // Map each comment to UserCommentDTO.CommentDTO
        // .collect(Collectors.toList());

//     for (int i = 0; i < targetUser.getPostDTO().size(); i++) {
//       insideList = targetUser.getPostDTO().get(i).getCommentDTO().stream()//
//           .map(comment -> userPostCommentMapper.map(comment))//
//           .collect(Collectors.toList());
// [[1,2,3],[4,5,6]] -> map -> [[1,2,3,4,5,6]]
// [[1,2,3],[4,5,6]] -> flatmap -> [1,2,3,4,5,6]

//     }
    // targetUser.getPostDTO().forEach(post -> {
    // post.getCommentDTO().stream()//

    // .map(comment -> userPostCommentMapper.map(comment))//
    // .collect(Collectors.toList());
    // });

  //   result.setId(convertUserID);//
  //   result.setName(targetUser.getName());
  //   result.setCommentDTOs(insideList);
  //   return result;
  // }

  // @Override
  // public List<UserCommentDTO> getUserCommentDTO() {
  // List <User> userList = this.jphCommentService.getUser();
  // List<Comment> commentList = this.jphCommentService.getComment();

  // List<UserPostCommentDTO> UserCommentDTOList = userList.Stream().map(user->{
  // List <CommentDTO> commmentDTOs = commentList.stream()
  // .filter(comment-> comment.getPostId().equals(user.getId()))
  // .map(comment -> userCommentMapper.mapTODTO(comment))
  // .collect(Collectors.toList());
  // })

  // UserCommentDTO userCommentDTO = userCommentMapper.mapToDTO(user);

  // userCommentDTO.setCommentDTO(commentDTOs);

  // return userCommentDTO;
  // }).collect(Collectors.toList());

  // return userCommentDTOList;

  // }
  // }
}
