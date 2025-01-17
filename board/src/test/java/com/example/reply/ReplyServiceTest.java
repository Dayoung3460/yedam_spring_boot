package com.example.reply;

import com.example.board.service.reply.ReplyDTO;
import com.example.board.service.reply.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@Slf4j
@SpringBootTest
public class ReplyServiceTest {
  
  @Autowired
  ReplyService replyService;
  
//  @Test
//  @DisplayName("댓글 조회")
//  public void getReplyList() {
//    // given
//    long bno = 3014669;
//
//    // when
//    List<ReplyDTO> replyList = replyService.getList(bno);
//
//    // then
//    log.info("replyList:{}", replyList);
//    assertThat(replyList).isNotEmpty();
//  }
  
  @Test
  @DisplayName("댓글 수정")
  public void update() {
    // given
    ReplyDTO reply = ReplyDTO.builder()
      .rno(4L)          //  실행전 존재하는번호인지 확인할 것
      .reply("댓글수정")
      .replyer("김수정")
      .build();

    // when
    boolean result = replyService.modify(reply);

    // then
    log.info("result:{}", result);
    assertThat(result).isEqualTo(true);
  }

}