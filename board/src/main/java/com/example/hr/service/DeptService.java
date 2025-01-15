package com.example.hr.service;

import java.util.List;

public interface DeptService {
  public List<DeptDTO> getList(DeptSearchDTO searchDTO);
  public int count(DeptSearchDTO searchDTO);
  public DeptDTO read(long departmentId);
}
