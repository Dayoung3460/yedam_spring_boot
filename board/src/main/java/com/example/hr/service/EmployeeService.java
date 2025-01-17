package com.example.hr.service;

import java.util.List;

public interface EmployeeService {
  public boolean register(EmployeeDTO employeeDTO);
  
  public List<EmployeeDTO> getList();
  
}
