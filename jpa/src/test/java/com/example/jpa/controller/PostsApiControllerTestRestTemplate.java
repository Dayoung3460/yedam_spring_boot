package com.example.jpa.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.jpa.domain.Posts;
import com.example.jpa.domain.PostsRepository;
import com.example.jpa.web.dto.PostsSaveRequestDto;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTestRestTemplate {
  
  @LocalServerPort
  private int port;
  
  @Autowired
  private TestRestTemplate restTemplate;
  
  @Autowired
  private PostsRepository postsRepository;
  
  @AfterAll
  public void tearDown() throws Exception {
    postsRepository.deleteAll();
  }
  
  // @Test
  public void Posts_등록된다() throws Exception {
    // given
    String title = "title";
    String content = "content";
    PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder().title(title).content(content).author("author")
      .build();
    
    String url = "http://localhost:" + port + "/api/v1/posts";
    
    // when
    ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
    
    // then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isGreaterThan(0L);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    List<Posts> all = postsRepository.findAll();
    assertThat(all.get(0).getTitle()).isEqualTo(title);
    assertThat(all.get(0).getContent()).isEqualTo(content);
    
  }
}
