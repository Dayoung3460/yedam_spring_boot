package com.example.board.serviceImpl;

import com.example.board.mapper.BoardMapper;
import com.example.board.service.board.BoardDTO;
import com.example.board.service.board.BoardSearchDTO;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
// bean 등록. 설정안해주면 No qualifying bean of type 에러남
// 비지니스로직 처리하는 클래스에 사용
// @Component의 확장형태. 다른 클래스에서 @Autowired 또는 생성자 주입 통해 사용가능

@Service
// 클래스에 정의된 final 필드를 파라미터로 받는 생성자 자동으로 만들어줌
// final 필드는 꼭 초기화를 해줘야함
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
  private final BoardMapper boardMapper;
  
  // BoardMapper를 주입받는 생성자
  // @RequiredArgsConstructor가 있어서 필요없음
//  public BoardServiceImpl(BoardMapper boardMapper) {
//    this.boardMapper = boardMapper;
//  }

  @Override
  public boolean register(BoardDTO board) {
    return boardMapper.insert(board) > 0;
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
  public List<BoardDTO> getList(BoardSearchDTO searchDTO) {
    return boardMapper.getList(searchDTO);
  }
  
  @Override
  public int count(BoardSearchDTO searchDTO) {
    return boardMapper.count(searchDTO);
  }
}
