package com.example.board.serviceImpl;

import com.example.board.mapper.ReplyMapper;
import com.example.board.service.reply.ReplyDTO;
import com.example.board.service.reply.ReplyPageDTO;
import com.example.board.service.reply.ReplySearchDTO;
import com.example.board.service.reply.ReplyService;
import com.example.common.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
  private final ReplyMapper replyMapper;
  
  @Override
  public int register(ReplyDTO vo) {
    return replyMapper.register(vo);
  }
  
  @Override
  public boolean remove(Long rno) {
    return replyMapper.delete(rno) > 0;
  }
  
  @Override
  public ReplyDTO get(Long rno) {
    return replyMapper.read(rno);
  }
  
  @Override
  public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno) {
    Paging paging = new Paging();
    int cnt = replyMapper.getCountByBno(bno);
    
    paging.setPage(replySearch.getPage());
    paging.setPageUnit(replySearch.getAmount());
    paging.setTotalRecord(cnt);
    return new ReplyPageDTO(
      cnt,
      paging,
      replyMapper.getList(replySearch, bno)
    );
  }
  
  @Override
  public boolean modify(ReplyDTO reply) {
    return replyMapper.modify(reply);
  }
}
