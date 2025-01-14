package com.example.demo.dept;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentsDTO {
  private int departmentId;
  private String departmentName;
  private int managerId;
  private int locationId;
}
