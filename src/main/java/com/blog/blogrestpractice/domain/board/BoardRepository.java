package com.blog.blogrestpractice.domain.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager em;

    public Long save(Board board) {
        em.persist(board);
        return board.getId();
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class)
            .getResultList();
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    public void delete(Board board) {
        em.remove(board);
    }
}
