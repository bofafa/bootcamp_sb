package com.bootcamp.demo_post.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "comments")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CommentEntity  implements Serializable {
  @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String email;
  @Column(name = "comment",length = 1000)
  private String body;


   @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  private PostEntity post;
}

