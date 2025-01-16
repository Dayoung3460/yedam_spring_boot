package com.example.board.service.board;

import lombok.Data;

// 해당 필드값들을 페이지 안에서 저장하기 위한 클래스
// Paging 클래스는 페이징 관련 계산을 하기 위한 클래스

@Data
public class BoardSearchDTO {
  int start;
  int end;
  String type;
  String keyword;
  int pageUnit;
  
  public String[] getTypeArr() {
    return type == null ? new String[]{} : type.split("");
  }
}