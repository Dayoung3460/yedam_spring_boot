package com.example.jpa.service;

import com.example.jpa.domain.Posts;
import com.example.jpa.domain.PostsRepository;
import com.example.jpa.web.dto.PostsListResponseDto;
import com.example.jpa.web.dto.PostsResponseDto;
import com.example.jpa.web.dto.PostsSaveRequestDto;
import com.example.jpa.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
  private final PostsRepository postsRepository;
  
  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }
  
  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다1. id=" + id));
    
    posts.update(requestDto.getTitle(), requestDto.getContent());
    
    return id;
  }
  
  @Transactional
  public void delete (Long id) {
    Posts posts = postsRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다2. id=" + id));
    
    postsRepository.delete(posts);
  }
  
  @Transactional(readOnly = true)
  public PostsResponseDto findById(Long id) {
    Posts entity = postsRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다3. id=" + id));
    
    return new PostsResponseDto(entity);
  }
  
  @Transactional(readOnly = true)
  public List<PostsListResponseDto> findAllDesc() {
//    return postsRepository.findAllDesc().stream()
//      .map(PostsListResponseDto::new)
//      .collect(Collectors.toList());
    
    List<Posts> list = postsRepository.findAllDesc();
    
//    List<PostsListResponseDto> dtoList = new ArrayList<>();
//    list.forEach(post -> dtoList.add(new PostsListResponseDto(post)));
//    return dtoList;
    
    return list.stream().map(post -> new PostsListResponseDto(post)).collect(Collectors.toList());
  }
}