package com.example.hr.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
  private Long employeeId;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private Date hireDate;
  private String jobId;
  private Long salary;
  private Double commissionPct;
  private Long managerId;
  private Long departmentId;
  private String jobTitle;
}
