package com.example.security.service;

import lombok.Data;
import java.util.List;

@Data
public class UserDTO  {
  private Long id;
  private String loginId;
  private String password;
  private String fullName;
  private String deptName;
  
  private List<RoleDTO> roles;
}
