package com.example.demo.service;

import java.util.List;

public interface BookService {
  public boolean register(BookDTO book);
  
  public List<BookDTO> getList();
}
