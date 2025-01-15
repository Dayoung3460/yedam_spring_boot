package com.example.hr.mapper;
import com.example.hr.service.DeptDTO;
import com.example.hr.service.DeptSearchDTO;

import java.util.List;

public interface DeptMapper {
  List<DeptDTO> getList(DeptSearchDTO searchDTO);
  int count(DeptSearchDTO searchDTO);
  DeptDTO read(long departmentId);
}
