package com.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestBody;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class ObjectMapperTest {
  @Test
  public void test() throws JsonProcessingException {
    String str = """
        {"name": "Hong", "age": 20}
      """;
    // jackson에서 가져오는 객체
    ObjectMapper om = new ObjectMapper();
    // str를 MemberVO 타입으로 변환시켜줌
    MemberVO vo = om.readValue(str, MemberVO.class);
    assertThat(vo.getName()).isEqualTo("Hong");
    
    vo.setAge(30);
    // object를 string으로 변환
    String data = om.writeValueAsString(vo);
    log.info("data:{}", data);
  }
}
