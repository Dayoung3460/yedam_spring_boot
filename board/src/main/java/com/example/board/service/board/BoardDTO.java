package com.example.board.service.board;

import jakarta.validation.constraints.NotBlank;
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
  // long이 아니고 Long으로 해줘야함. 
  // long은 null 할당이 불가해서 초기화할 때 null 넣어주면 에러
  // wrapper class: null 가능
  private Long bno;
  @NotBlank
  private String title;
  @NotBlank
  private String content;
  @NotBlank
  private String writer;
  private Date regdate;
  private Date updatedate;
  private Long replyCnt;
}
