package com.blog.blogrestpractice.service;

import com.blog.blogrestpractice.domain.board.Board;
import com.blog.blogrestpractice.domain.board.BoardRepository;
import com.blog.blogrestpractice.domain.user.User;
import com.blog.blogrestpractice.dto.board.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto, User user) {
        boardSaveRequestDto.setUser(user);
        Board board = boardSaveRequestDto.toEntity();
        return boardRepository.save(board);
    }
}
