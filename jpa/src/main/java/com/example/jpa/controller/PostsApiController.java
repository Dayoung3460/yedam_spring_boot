package com.example.jpa.controller;

import com.example.jpa.service.PostsService;
import com.example.jpa.web.dto.PostsListResponseDto;
import com.example.jpa.web.dto.PostsResponseDto;
import com.example.jpa.web.dto.PostsSaveRequestDto;
import com.example.jpa.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
  
  private final PostsService postsService;
  
  @PostMapping("/api/v1/posts")
  public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto requestDto) {
    postsService.save(requestDto);
    return requestDto;
  }
  
  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
    return postsService.update(id, requestDto);
  }
  
  @DeleteMapping("/api/v1/posts/{id}")
  public Long delete(@PathVariable Long id) {
    postsService.delete(id);
    return id;
  }
  
  @GetMapping("/api/v1/posts/{id}")
  public PostsResponseDto findById(@PathVariable Long id) {
    return postsService.findById(id);
  }
  
  @GetMapping("/api/v1/posts/list")
  public List<PostsListResponseDto> findAll() {
    return postsService.findAllDesc();
  }
}