package com.example.board.service.reply;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplySearchDTO {
  int page = 1;
  int amount = 3; // 한페이지에 댓글 보여주는 개수
  
  // page group의 첫댓글 rownum
  public int getStart() {
    return (page - 1) * amount + 1;
  }
  
  // page group의 마지막 댓글 rownum
  public int getEnd() {
    return page * amount;
  }
}
