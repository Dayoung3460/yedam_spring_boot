package com.example.ajaxtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ControllerTest {
  @Autowired MockMvc mvc;
  
  @Test
  @DisplayName("ticket 단건 조회")
  void getreply() throws Exception {
    //given
    String url = "/getSample";
    
    //when
    mvc.perform(
        get(url).
          accept(MediaType.APPLICATION_JSON)
      )
      //then
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.firstName").value("Dayoung"))
      .andDo(print());
    
  }
}
