package com.example.board.service.reply;

import java.util.List;

public interface ReplyService {
  public boolean register(ReplyDTO vo);
  
  public boolean remove(Long rno);
  
  public ReplyDTO get(Long rno);
  
  public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno);
  
  List<ReplyDTO> getListByBno(Long bno);
  
  boolean modify(ReplyDTO reply);
}
