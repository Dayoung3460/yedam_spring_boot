package com.example.security;

import com.example.security.mapper.UserMapper;
import com.example.security.service.RoleDTO;
import com.example.security.service.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class UserMapperTest {
  @Autowired
  UserMapper userMapper;
  
  @Test
  public void test() {
    UserDTO user = userMapper.getUser("user");
//    List<RoleDTO> roleList = userMapper.getRole(user.getId());
    log.info("user: {}", user.toString());
  }
}
