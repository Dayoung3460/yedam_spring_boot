package com.example.board.controller;

import com.example.board.service.BoardDTO;
import com.example.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board/*")
//@RequiredArgsConstructor
//@AllArgsConstructor
public class BoardController {
  
  // BoardService 의존성을 주입받음
  // @Service로 등록된 구현체는 빈으로 등록 돼있음
  // Spring은 구현체를 찾아서 컨트롤러에 주입함
  // ** 다형성(Polymorphism)
  
  // Spring이 구현체를 선택하는 원리
  // : 스프링은 @Service로 등록된 구현체를 컨테이너에서 검색하여 주입
  // 구현체가 여러개면 @Qualifier or @Primary 사용해서 어떤 구현체 사용할지 지정
  private final BoardService service;

  @Autowired
  // 구현체가 여러개면 @Qualifier로 직접 설정해주면됨
  // BoardServiceImpl class가 빈으로 등록되면 boardServiceImpl
  public BoardController(@Qualifier("boardServiceImpl")BoardService service) {
    this.service = service;
  }
  
  @GetMapping("/register")
  public void register() {	}

  @PostMapping("/register")
  // RedirectAttributes: 리다이렉트 뷰로 데이터 전달하기 위해 사용
  // data 임시 저장하고 리다이렉트되는 url에서 데이터 받을 수 있음
  public String register(BoardDTO board, RedirectAttributes rttr) {

    log.info("register={}", board);

    // 서비스 구현체의 메서드를 실행함
    Boolean bool = service.register(board);

    // addFlashAttribute: 페이지 새로 로드되면 자동으로 삭제됨
    rttr.addFlashAttribute("result", bool);
    
    return "redirect:/board/list"; // status: 302
  }

  @GetMapping({ "/get", "/modify" })
  public void get(@RequestParam("bno") Long bno, Model model) {

    log.info("/get or modify");
    model.addAttribute("board", service.get(bno));
  }

  @PostMapping("/modify")
  public String modify(BoardDTO board) {
    log.info("modify:" + board);

    if (service.modify(board)) {
      service.modify(board);
    }

    return "redirect:/board/list";
  }

  @GetMapping("/remove")
  public String remove(@RequestParam("bno") Long bno) 	{

    log.info("remove..." + bno);
    if (service.remove(bno)) {
      service.remove(bno);
    }
    return "redirect:/board/list";
  }


  @GetMapping("/list")
  public void list(Model model) {
    log.info("list");
    model.addAttribute("list", service.getList());
  }
}
