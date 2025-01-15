package com.example.board;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.ui.ModelMap;

import java.util.Objects;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 브라우저 대신 해당 url 접속하여 테스트를 할 수 있음
// 스프링부트에서 MockMvc를 자동으로 설정. 테스트 컨텍스트에 주입
// 스프링 MVC application에서 컨트롤러와 관련된 테스트 작성할 때 사용됨
@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class BoardControllerTest {
  @Autowired
  MockMvc mvc;
  
  @Test
  @DisplayName("list controller")
  void list() throws Exception {
//    mvc.perform(get("/board/list"))
//      .andExpect(status().isOk()) // 200
//      .andDo(MockMvcResultHandlers.print());
//
    ModelMap map = Objects.requireNonNull(mvc.perform(get("/board/list")
          .param("page", "100"))
      .andReturn()
      .getModelAndView())
      .getModelMap();
    
    log.debug(Objects.requireNonNull(map.getAttribute("list")).toString());
    log.debug(Objects.requireNonNull(map.getAttribute("paging")).toString());
  }
  
  @Test
  @DisplayName("register controller")
  void register() throws Exception  {
    String param = "title=test&content=내용&writer=kim";
    // perform(): server에 요청
    mvc.perform(post("/board/register")
        .content(param)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
      )
      .andExpect(status().isFound()) // 302
      // register 후에 /board/list로 리다이렉트함
      .andExpect(header().string("Location", "/board/list"))
      .andDo(MockMvcResultHandlers.print());
    ;
  }
}
