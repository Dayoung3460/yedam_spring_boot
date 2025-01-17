package com.example.hr.mapper;

import com.example.hr.service.EmployeeDTO;

import java.util.List;

public interface EmployeeMapper {
  List<EmployeeDTO> getList();
  
  int insert(EmployeeDTO employeeDTO);
}
