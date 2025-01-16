package com.example.board;

import com.example.board.service.board.BoardDTO;
import com.example.board.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
// 통합테스트 수행할 때 사용
// Spring application context 로드
@SpringBootTest
public class BoardServiceTest {
  @Autowired
  BoardService boardService;
  
  @Test
  @DisplayName("update")
  public void update() {
    BoardDTO board = BoardDTO.builder()
      .bno(4L)
      .title("updated title")
      .content("updated content")
      .writer("user01")
      .build();
    
    boolean result = boardService.modify(board);
    
    assertThat(result).isEqualTo(true);
  }
}
