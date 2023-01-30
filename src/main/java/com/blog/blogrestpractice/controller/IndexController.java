package com.blog.blogrestpractice.controller;

import com.blog.blogrestpractice.domain.board.Board;
import com.blog.blogrestpractice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "index";
    }
}
