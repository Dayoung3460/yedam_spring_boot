package com.example.board.mapper;

import com.example.board.service.reply.ReplyDTO;
import com.example.board.service.reply.ReplySearchDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
  boolean modify(ReplyDTO reply);
  
  public int register(ReplyDTO replyDTO);
  
  public int update(ReplyDTO replyDTO);
  
  public int delete(Long rno);
  
  public ReplyDTO read(Long bno);
  
  public List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri,
                                @Param("bno") Long bno);
  
  public int getCountByBno(Long bno);
}
