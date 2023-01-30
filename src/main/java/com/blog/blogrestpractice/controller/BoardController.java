package com.blog.blogrestpractice.controller;

import com.blog.blogrestpractice.domain.board.Board;
import com.blog.blogrestpractice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/save")
    public String save() {
        return "layout/board/board-save";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Board board = boardService.findOne(id);
        boardService.updateCount(id);
        model.addAttribute("board", board);
        return "layout/board/board-detail";
    }

    @GetMapping("/board/{id}/update")
    public String update(@PathVariable("id") Long id, Model model) {
        Board board = boardService.findOne(id);
        model.addAttribute("board", board);
        return "layout/board/board-update";
    }
}
