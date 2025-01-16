package com.example.board.service.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyDTO {
  private Long rno;
  private Long bno;
  private String reply;
  private String replyer;
  private Date replydate;
  private Date updatedate;
}
