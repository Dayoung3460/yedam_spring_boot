package com.example.jpa.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.domain.Posts;
import com.example.jpa.domain.PostsRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PostsRepositoryTest {
  
  @Autowired
  PostsRepository postsRepository;
  
  @AfterAll
  public void cleanup() {
    postsRepository.deleteAll();
  }
  
  @Test
  public void 게시글저장_불러오기() {
    //given
    String title = "테스트 게시글";
    String content = "테스트 본문";
    
    postsRepository.save(Posts.builder()
      .title(title)
      .content(content)
      .author("jojoldu@gmail.com")
      .build());
    
    //when
    List<Posts> postsList = postsRepository.findAll();
    
    //then
    Posts posts = postsList.get(0);
    assertThat(posts.getTitle()).isEqualTo(title);
    assertThat(posts.getContent()).isEqualTo(content);
  }
}