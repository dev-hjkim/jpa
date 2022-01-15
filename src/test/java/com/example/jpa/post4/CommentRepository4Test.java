package com.example.jpa.post4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CommentRepository4Test {
    @Autowired
    CommentRepository4 commentRepository;

    @Autowired
    PostRepository4 postRepository;

    @Test
    public void getComment() {
        System.out.println("getById start!");
        commentRepository.getById(1l);

        System.out.println("=========================");

        commentRepository.findById(1l);
    }
}