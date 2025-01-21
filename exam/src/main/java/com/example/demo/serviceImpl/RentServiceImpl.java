package com.example.demo.serviceImpl;

import com.example.demo.mapper.BookMapper;
import com.example.demo.service.RentDTO;
import com.example.demo.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {
  private final BookMapper bookMapper;
  
  
  @Override
  public List<RentDTO> getRentList() {
    return bookMapper.getRentList();
  }
}
