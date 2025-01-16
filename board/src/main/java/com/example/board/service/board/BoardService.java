package com.example.board.service.board;

import java.util.List;

public interface BoardService {
  public boolean register(BoardDTO board);

  public boolean modify(BoardDTO board);

  public boolean remove(Long bno);

  public BoardDTO get(Long bno);

  public List<BoardDTO> getList(BoardSearchDTO searchDTO);
  public int count(BoardSearchDTO searchDTO);
}
