package com.bootcamp.demo_post.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_post.entity.AddressEntity;
import com.bootcamp.demo_post.entity.CommentEntity;
import com.bootcamp.demo_post.entity.CompanyEntity;
import com.bootcamp.demo_post.entity.GeoEntity;
import com.bootcamp.demo_post.entity.PostEntity;
import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.User;
import com.bootcamp.demo_post.service.JPHCommentService;
import com.bootcamp.demo_post.service.PostService;
import com.bootcamp.demo_post.service.UserService;

// @Autowired(required = false)
// private CommandLineRunner runner;
// runner.run();

@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private PostService postService;

  @Autowired
  private UserService userService;

  @Autowired
  private JPHCommentService jphCommentService;

  @Override
  public void run(String... args) throws Exception {
    // 獲取所有數據
    List<Post> posts = jphCommentService.getPost();
    List<Comment> comments = jphCommentService.getComment();
    List<User> users = jphCommentService.getUser();
    List<AddressEntity> addressEntities = jphCommentService.getAddressEntity();
    List<CompanyEntity> companyEntities = jphCommentService.getCompanyEntity();
    List<GeoEntity> geoEntities = jphCommentService.getGeoEntity();

    // 將 User DTO 轉換為 User 實體類並保存
    List<UserEntity> userEntities = users.stream()
        .map(uDto -> UserEntity.builder()
            .id(uDto.getId())
            .name(uDto.getName())
            .username(uDto.getUsername())
            .phone(uDto.getPhone())
            .website(uDto.getWebsite())
            .email(uDto.getEmail())
            .build())
        .collect(Collectors.toList());
    userService.saveAll(userEntities);

    // 將 Post DTO 轉換為 Post 實體類，並將其與相應的 User 和 Comment 進行關聯
    List<PostEntity> postEntities = posts.stream().map(pDto -> {

      PostEntity postEntity = PostEntity.builder() //
          .title(pDto.getTitle()) //
          .body(pDto.getBody()) //
          .build();

      userEntities.forEach(user -> {
        if (user.getId().equals(pDto.getUserId()))
          postEntity.setUser(user);
      });

      List<CommentEntity> commentEntities = comments.stream()
          .filter(cDto -> cDto.getPostId().equals(pDto.getId()))
          .map(cDto -> CommentEntity.builder()
              .body(cDto.getBody())
              .email(cDto.getEmail())
              .name(cDto.getName())
              .post(postEntity)
              .build())
          .collect(Collectors.toList());
      postEntity.setComments(commentEntities);

      return postEntity;
    })
        .collect(Collectors.toList());
    postService.saveAll(postEntities);

    // 將地址與使用者進行關聯並保存

    addressEntities.forEach(address -> {
      userEntities.forEach(user -> {
        if (address.getId().equals(user.getId())) {
          address.setUser(user); // Enitiy for map by
        }

      });
    });
    userService.saveAlladdress(addressEntities);

    // 將地理位置信息與地址進行關聯並保存
    geoEntities.forEach(geo -> {
      addressEntities.forEach(address -> {
        if (geo.getId().equals(address.getId())) {
          geo.setAddress(address);
        }
        userService.saveAllGeos(geoEntities);
      });
    });

    // 將公司信息與使用者進行關聯並保存
    companyEntities.forEach(company -> {
      userEntities.forEach(user -> {
        if (company.getId().equals(user.getId())) {
          company.setUser(user);
        }
      });
    });
    userService.saveAllcompany(companyEntities);

  }
}

// @Override
// public void run(String... args) throws Exception {
// // call jph service
// // insert into database (design tables by entity)
// List<Post> posts = this.jphCommentService.getPost();
// List<Comment> comments = this.jphCommentService.getComment();
// List<User> users = this.jphCommentService.getUser();
// List<AddressEntity> addressEntitys =
// this.jphCommentService.getAddressEntity();
// List<CompanyEntity> companyEntitys =
// this.jphCommentService.getCompanyEntity();
// List<GeoEntity> geoEntitys = this.jphCommentService.getGeoEntity();
// List<PostEntity> postEntitys = this.jphCommentService.getPostEntity();

// List<UserEntity> userEntities = users.stream().map(uDto -> {
// UserEntity userEntity = UserEntity.builder()
// .id(uDto.getId())
// .name(uDto.getName())
// .username(uDto.getUsername())
// .phone(uDto.getPhone())
// .website(uDto.getWebsite())
// .email(uDto.getEmail())
// .build();
// // .collect(Collectors.toList());
// return userEntity;
// }).collect(Collectors.toList());

// userService.saveAll(userEntities);

// List<PostEntity> postEntities = posts.stream().map(pDto -> {

// PostEntity postEntity = PostEntity.builder() //
// .title(pDto.getTitle()) //
// .body(pDto.getBody()) //
// .build();

// userEntities.forEach(user -> {
// if (user.getId().equals(pDto.getUserId()))
// postEntity.setUser(user);
// });

// List<CommentEntity> commentEntities = comments.stream() //
// .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
// .map(cDto -> {
// CommentEntity commentEntity = CommentEntity.builder() //
// .body(cDto.getBody()) //
// .email(cDto.getEmail()) //
// .name(cDto.getName()) //
// .build();
// commentEntity.setPost(postEntity);
// return commentEntity;
// }) //
// .collect(Collectors.toList());
// postEntity.setComments(commentEntities);
// return postEntity;
// }).collect(Collectors.toList());

// // Insert into Posts, Comments
// postService.saveAll(postEntities);
// // userService.saveAll(userEntities);

// addressEntitys.forEach(address -> {
// userEntities.forEach(user -> {
// if (address.getId().equals(user.getId())) {
// // user.setAddress(address);
// address.setUser(user); // Enitiy for map by
// }

// });
// });
// userService.saveAlladdress(addressEntitys);
// geoEntitys.forEach(geo -> {
// addressEntitys.forEach(address -> {
// if (geo.getId().equals(address.getId())) {
// geo.setAddress(address);
// }

// });
// });

// companyEntitys.forEach(company -> {
// userEntities.forEach(user -> {
// if (company.getId().equals(user.getId())) {
// company.setUser(user); // Enitiy for map by
// }

// });
// });

// userService.saveAllcompany(companyEntitys);

// userService.saveAllGeos(geoEntitys);

// // userService.saveAlladdress(addressEntitys);

// postService.saveAll(postEntities);

// }
// }