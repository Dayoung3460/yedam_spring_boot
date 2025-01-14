package com.example.board.controller;

import com.example.board.service.BoardDTO;
import com.example.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/board/*")
//@AllArgsConstructor
public class BoardController {
  private final BoardService service;

  @Autowired
  public BoardController(BoardService service) {
    this.service = service;
  }
  
  @GetMapping("/register")
  public void register() {	}

  @PostMapping("/register")
  public String register(BoardDTO board, RedirectAttributes rttr) {

    log.info("register: " + board);

    service.register(board);

    rttr.addFlashAttribute("result", board.getBno());

    return "redirect:/board/list";
  }

  @GetMapping({ "/get", "/modify" })
  public void get(@RequestParam("bno") Long bno, Model model) {

    log.info("/get or modify");
    model.addAttribute("board", service.get(bno));
  }

  @PostMapping("/modify")
  public String modify(BoardDTO board, RedirectAttributes rttr) {
    log.info("modify:" + board);

    if (service.modify(board)) {
      rttr.addFlashAttribute("result", "success");
    }

    return "redirect:/board/list";
  }

  @PostMapping("/remove")
  public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) 	{

    log.info("remove..." + bno);
    if (service.remove(bno)) {
      rttr.addFlashAttribute("result", "success");
    }
    return "redirect:/board/list";
  }


  @GetMapping("/list")
  public void list(Model model) {

    log.info("list");
    model.addAttribute("list", service.getList());

  }

}
