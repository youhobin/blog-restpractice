package com.blog.blogrestpractice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager em;

    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }

    public User find(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
            .getResultList();
    }

    public Optional<User> findByUsername(String username) {
        return findAll().stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst();
    }

    public void deleteAll() {
        em.clear();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }
}
