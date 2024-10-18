package com.bootcamp.demo_post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{
  private Integer id;
  private String name;
  private String username;
  private Address address;
  private String phone;
  private String email;
  private String website;
  private Company company;
  private Integer addressId;
  private Integer companyId;
  private Integer GeoId;



  @Getter
  @Builder
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    private Integer geoId;

    @Getter
    @Builder
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @Builder
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}

