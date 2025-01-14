package com.example.board.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
  public void register(BoardDTO board);

  public boolean modify(BoardDTO board);

  public boolean remove(Long bno);

  public BoardDTO get(Long bno);

  public List<BoardDTO> getList();
}
