package com.example.demo.serviceImpl;

import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookDTO;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
  private final BookMapper bookMapper;
  
  
  @Override
  public boolean register(BookDTO book) {
    return bookMapper.insert(book) > 0;
  }
  
  @Override
  public List<BookDTO> getList() {
    return bookMapper.getList();
  }
}
