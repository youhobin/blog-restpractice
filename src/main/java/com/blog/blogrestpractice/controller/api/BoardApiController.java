package com.blog.blogrestpractice.controller.api;

import com.blog.blogrestpractice.config.auth.PrincipalDetail;
import com.blog.blogrestpractice.dto.board.BoardSaveRequestDto;
import com.blog.blogrestpractice.dto.board.BoardUpdateRequestDto;
import com.blog.blogrestpractice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.save(boardSaveRequestDto, principalDetail.getUser());
    }

    @DeleteMapping("/api/v1/board/{id}")
    public Long deleteById(@PathVariable("id") Long id) {
        boardService.deleteById(id);
        return id;
    }

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable("id") Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return boardService.update(id, boardUpdateRequestDto);
    }
}
