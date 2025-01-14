package com.example.board.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
// 패키지 프라이빗(package-private) 접근 권한을 가지는 생성자를 생성
@Builder
//  public 생성자를 명시적으로 추가
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
  private Long bno;
  private String title;
  private String content;
  private String writer;
  private Date regdate;
}
