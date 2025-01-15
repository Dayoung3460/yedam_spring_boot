package com.example.hr.serviceImpl;

import com.example.hr.mapper.DeptMapper;
import com.example.hr.service.DeptDTO;
import com.example.hr.service.DeptSearchDTO;
import com.example.hr.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {
  
  private final DeptMapper deptMapper;
  
  @Override
  public List<DeptDTO> getList(DeptSearchDTO searchDTO) {
    return deptMapper.getList(searchDTO);
  }
  
  @Override
  public int count(DeptSearchDTO searchDTO) {
    return deptMapper.count(searchDTO);
  }
  
  @Override
  public DeptDTO read(long departmentId) {
    return deptMapper.read(departmentId);
  }
}
