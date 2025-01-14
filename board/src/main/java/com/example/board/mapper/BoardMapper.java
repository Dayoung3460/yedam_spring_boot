package com.example.board.mapper;

import com.example.board.service.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BoardMapper {
  
  List<BoardDTO> getList();
  
  int insert(BoardDTO board);

  int insertSelectKey(BoardDTO board);

  BoardDTO read(long bno);

  int delete(long l);

  int update(BoardDTO board);
}
