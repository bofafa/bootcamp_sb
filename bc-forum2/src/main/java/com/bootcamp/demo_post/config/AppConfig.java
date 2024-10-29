package com.bootcamp.demo_post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean (name = "JPHRestTemplate")
  RestTemplate restTemplateForJPH(){
    return new RestTemplate();
  }

  @Bean (name = "ABCRestTemplate")
   RestTemplate restTemplateForABC(){
    return new RestTemplate();
  }
  @Bean
  RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    // You will store key as String and value as JSON String
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
    }

