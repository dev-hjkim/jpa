package com.example.jpa.post2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository2 extends JpaRepository<Post2, Long>, PostCustomRepository<Post2> {
}
