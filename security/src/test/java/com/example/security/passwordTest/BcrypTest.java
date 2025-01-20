package com.example.security.passwordTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class BcrypTest {
  @Test
  public void test() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
    String result = encoder.encode("1234");
    log.info("result: {}", result);
    assertThat(encoder.matches("1234", result));
  }
}
