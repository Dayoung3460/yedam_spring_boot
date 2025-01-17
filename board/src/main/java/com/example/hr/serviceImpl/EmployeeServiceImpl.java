package com.example.hr.serviceImpl;

import com.example.hr.mapper.EmployeeMapper;
import com.example.hr.service.EmployeeDTO;
import com.example.hr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeMapper employeeMapper;
  
  @Override
  public boolean register(EmployeeDTO employeeDTO) {
    return employeeMapper.insert(employeeDTO) > 0;
  }
  
  @Override
  public List<EmployeeDTO> getList() {
    return employeeMapper.getList();
  }
}
