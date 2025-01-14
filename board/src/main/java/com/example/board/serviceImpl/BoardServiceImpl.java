package com.example.board.service;

import com.example.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
  private final BoardMapper boardMapper;

  // BoardMapper를 주입받는 생성자
  public BoardServiceImpl(BoardMapper boardMapper) {
    this.boardMapper = boardMapper;
  }

  @Override
  public void register(BoardDTO board) {
    boardMapper.insert(board);
  }

  @Override
  public boolean modify(BoardDTO board) {
    return boardMapper.update(board) > 0;
  }

  @Override
  public boolean remove(Long bno) {
    return boardMapper.delete(bno) > 0;
  }

  @Override
  public BoardDTO get(Long bno) {
    return boardMapper.read(bno);
  }

  @Override
  public List<BoardDTO> getList() {
    return boardMapper.getList();
  }
}
