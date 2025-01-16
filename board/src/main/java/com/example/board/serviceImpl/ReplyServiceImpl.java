package com.example.board.serviceImpl;

import com.example.board.mapper.ReplyMapper;
import com.example.board.service.reply.ReplyDTO;
import com.example.board.service.reply.ReplyPageDTO;
import com.example.board.service.reply.ReplySearchDTO;
import com.example.board.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
  private final ReplyMapper replyMapper;
  
  @Override
  public boolean register(ReplyDTO vo) {
//    return replyMapper.;
    return false;
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
    return new ReplyPageDTO(
      replyMapper.getCountByBno(bno),
      replyMapper.getList(replySearch, bno)
    );
  }
  
  @Override
  public List<ReplyDTO> getListByBno(Long bno) {
    return List.of();
  }
  
  @Override
  public boolean modify(ReplyDTO reply) {
    return replyMapper.modify(reply);
  }
}
