package com.example.board.controller;

import com.example.board.service.board.BoardService;
import com.example.board.service.reply.ReplyDTO;
import com.example.board.service.reply.ReplyPageDTO;
import com.example.board.service.reply.ReplySearchDTO;
import com.example.board.service.reply.ReplyService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/replies/*")
public class ReplyController {
  private final ReplyService replyService;
  
  public ReplyController(ReplyService replyService) {
    this.replyService = replyService;
  }
  
  //수정
  @PutMapping("{rno}")
  public Boolean modify(@RequestBody ReplyDTO replyDTO,
                       @PathVariable(name="rno") Long rno) {
    replyDTO.setRno(rno);
    return replyService.modify(replyDTO);
  }
  
  // 삭제
  @DeleteMapping("{rno}")
  public String remove(@PathVariable(name = "rno") Long rno) {
    replyService.remove(rno);
    return "success";
  }
  
//  // 단건조회
  @GetMapping("/{rno}")
  public ReplyDTO get(@PathVariable("rno") Long rno) {
    log.info("replyService.get(rno): {}", replyService.get(rno));
    return replyService.get(rno);
  }
  
  // 목록조회
  @GetMapping("pages/{bno}/{page}")
  public ReplyPageDTO getList(@PathVariable(name = "page") int page,
                              @PathVariable(name = "bno") Long bno) {
    ReplySearchDTO replySearchDTO = new ReplySearchDTO(page, 3);
    return replyService.getList(replySearchDTO, bno);
  }
  
  @PostMapping("new")
  public Boolean register(@RequestBody ReplyDTO dto) {
    log.info("new dto = {}", dto);
    return replyService.register(dto) > 0;
  }
  
  
}
