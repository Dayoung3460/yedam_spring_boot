package com.example.security.mapper;

import com.example.security.service.RoleDTO;
import com.example.security.service.UserDTO;

import java.util.List;

public interface UserMapper {
  UserDTO getUser(String loginId);
  
  List<RoleDTO> getRole(Long id);
}
