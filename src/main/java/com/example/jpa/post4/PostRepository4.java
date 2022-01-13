package com.example.jpa.post4;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository4 extends JpaRepository<Post4, Long> {

    List<Post4> findByTitleStartsWith(String title);

    @Query("SELECT p FROM Post4 AS p WHERE p.title = ?1")
    List<Post4> findByTitle(String title, Sort sort);
}
