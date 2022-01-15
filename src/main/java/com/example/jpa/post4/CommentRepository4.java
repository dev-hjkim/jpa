package com.example.jpa.post4;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository4 extends JpaRepository<Comment4, Long> {

    @EntityGraph(attributePaths = {"post"})
    Comment4 getById(Long id);

    <T> List<T> findByPost_Id(Long id, Class<T> type);
}
