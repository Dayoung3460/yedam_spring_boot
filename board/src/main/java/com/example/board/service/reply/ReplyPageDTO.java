package com.example.board.service.reply;

import com.example.common.Paging;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReplyPageDTO {
  private int replyCnt;
  Paging paging;
  private List<ReplyDTO> list;
}