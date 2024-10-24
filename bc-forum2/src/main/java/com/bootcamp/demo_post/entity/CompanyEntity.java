package com.bootcamp.demo_post.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "company")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CompanyEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "company_id")
  private Integer id;
  private String name;
  @Column(name = "catch_phrase")
  private String catchPhrase;
  private String bs;

  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user; // getId() -> table}

}
