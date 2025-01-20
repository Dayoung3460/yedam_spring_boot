package com.example.security.service;

import com.example.security.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserMapper userMapper;
 
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDTO userDTO = userMapper.getUser(username);
    if(userDTO == null) {
      throw new UsernameNotFoundException("id check");
    }
    
    return new CustomerUser(userDTO);
  }
}
