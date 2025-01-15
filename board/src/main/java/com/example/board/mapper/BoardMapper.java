package com.example.board.mapper;

import com.example.board.service.BoardDTO;
import com.example.board.service.BoardSearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BoardMapper {
  
  // start, end 값 쿼리로 넘겨줘야함
  List<BoardDTO> getList(BoardSearchDTO searchDTO);
  
  int insert(BoardDTO board);

  int insertSelectKey(BoardDTO board);

  BoardDTO read(long bno);

  int delete(long l);

  int update(BoardDTO board);
  
  int count(BoardSearchDTO searchDTO);
}
