package com.example.board;

import com.example.board.service.board.BoardDTO;
import com.example.board.mapper.BoardMapper;
import com.example.board.service.board.BoardSearchDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class BoardMapperTests {
  
  @Autowired
  private BoardMapper mapper;
  
  @Test
  @DisplayName("게시글전체조회")
  public void testGetList() {
    //given
    BoardSearchDTO search = new BoardSearchDTO();
    search.setStart(1);
    search.setEnd(10);
    
    //when
    List<BoardDTO> list = mapper.getList(search);
    
    //then
    list.forEach((board) -> log.info(String.valueOf(board)));
//    assertNotNull(list);
    assertThat(list).isNotNull();
  }
  
  @Test
  @DisplayName("게시글 등록")
  public void testInsert() {
    //given
    BoardDTO board = new BoardDTO();
    board.setTitle("new post");
    board.setContent("hello!!!");
    board.setWriter("newbie");
    
    //when
    int cnt = mapper.insert(board);
    
    //then
    log.info(String.valueOf(board));
    assertEquals(cnt, 1);
    assertThat(cnt).isEqualTo(cnt);
  }
  
  @Test
  @DisplayName("selectkey가 있는 게시글 등록")
  public void testInsertSelectKey() {
    //given
    BoardDTO board = new BoardDTO();
    board.setTitle("새로 작성하는 글 select key");
    board.setContent("새로 작성하는 내용 select key");
    board.setWriter("newbie");
    //when
    int cnt = mapper.insertSelectKey(board);
    
    //then
    log.info(String.valueOf(board));
    assertEquals(cnt, 1);
  }
  
  @Test
  @DisplayName("게시글 상세조회")
  public void testRead() {
    //given
    long bno = 5L;
    
    //when
    BoardDTO board = mapper.read(bno);
    
    //then
    log.info(String.valueOf(board));
    assertEquals(board.getBno(), bno);
  }
  
  @Test
  @DisplayName("게시글 삭제")
  public void testDelete() {
    //given
    long bno = 5L;
    
    //when
    int cnt = mapper.delete(bno);
    
    //then
    log.info("DELETE COUNT: " + cnt);
//    assertEquals(cnt, 1);
  }
  
  @Test
  @DisplayName("게시글 수정")
  public void testUpdate() {
    //given
    // 실행전 존재하는 번호인지 확인할 것
    BoardDTO board = BoardDTO.builder()
      .bno(5L)
      .title("수정된 제목")
      .content("수정된 내용")
      .writer("user00")
      .build();
    
    //when
    int cnt = mapper.update(board);
    
    //then
    log.info("UPDATE COUNT: " + cnt);
    assertEquals(cnt, 1);
  }
}