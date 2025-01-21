package com.example.demo.mapper;

import com.example.demo.service.BookDTO;
import com.example.demo.service.RentDTO;

import java.util.List;

public interface BookMapper {
  List<BookDTO> getList();
  
  int insert(BookDTO book);
  List<RentDTO> getRentList();
}
