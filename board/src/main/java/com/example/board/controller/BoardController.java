package com.example.board.controller;

import com.example.common.Paging;
import com.example.board.service.board.BoardDTO;
import com.example.board.service.board.BoardSearchDTO;
import com.example.board.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  public void register(BoardDTO board) {	}

  @PostMapping("/register")
  // RedirectAttributes: 리다이렉트 뷰로 데이터 전달하기 위해 사용
  // data 임시 저장하고 리다이렉트되는 url에서 데이터 받을 수 있음
  // @Validated: BoardDTO에서 @NotBlank 설정해둬서 유효성 검사를 함
  // 그 결과가 바로 bindingResult로 들어감
  // 파라미터 순서가 @Validated 다음에 바로 BindingResult가 와야함
  public String register(@Validated BoardDTO board,
                         BindingResult bindingResult,
                         RedirectAttributes rttr) {

    // 값 세개(title, content, writer) 중 하나라도 빈 값으로 넘어오면 에러에 걸림
    if(bindingResult.hasErrors()) {
      return "/board/register";
    }
    
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
  public void list(Model model, BoardSearchDTO searchDTO, Paging paging) {
    log.info("list");
    
//    paging.setPageUnit(10);
    paging.setTotalRecord(service.count(searchDTO));
    
    searchDTO.setStart(paging.getFirst());
    searchDTO.setEnd(paging.getLast());
//    searchDTO.setPageUnit(paging.getPageUnit());
    
    // searchDTO, paging 의 값들도 model에 들어있음
    // list page에서는 boardSearchDTO 변수로 넘어감. 커맨드객체에서 첫글자만 소문자로
    //  --> Spring MVC에서 메소드의 파라미터로 전달된 객체들이 자동으로 모델에 추가됨
    // --> @ModelAttribute 가 생략됐다고 생각하면 됨
    model.addAttribute("list", service.getList(searchDTO));
  }
}
