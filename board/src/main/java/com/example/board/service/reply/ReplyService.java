package com.example.board.service.reply;

public interface ReplyService {
  public int register(ReplyDTO vo);
  
  public boolean remove(Long rno);
  
  public ReplyDTO get(Long rno);
  
  public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno);
 
  boolean modify(ReplyDTO reply);
}
