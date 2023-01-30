package com.blog.blogrestpractice.service;

import com.blog.blogrestpractice.domain.board.Board;
import com.blog.blogrestpractice.domain.board.BoardRepository;
import com.blog.blogrestpractice.domain.user.User;
import com.blog.blogrestpractice.dto.board.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findOne(Long id) {
        return boardRepository.findOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        Board board = boardRepository.findOne(id);
        boardRepository.delete(board);
    }
}
