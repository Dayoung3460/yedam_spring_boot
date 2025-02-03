package com.example.jpa.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
// BaseTimeEntity에서 필드 두개(createdDate, modifiedDate) 넘어옴
public class Posts extends BaseTimeEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(length = 500, nullable = false)
  private String title;
  
  @Column(columnDefinition = "clob", nullable = false)
  private String content;
  
  private String author;
  
  @Builder
  public Posts(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
  
  // update 쿼리 실행됨
  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
