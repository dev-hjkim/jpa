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
        Post4 post = new Post4();
        post.setTitle("jpa");
        Post4 savedPost = postRepository.save(post);

        Comment4 comment = new Comment4();
        comment.setComment("spring data jpa projection");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        commentRepository.save(comment);

        commentRepository.findByPost_Id(savedPost.getId(), CommentOnly.class).forEach(c -> {
            System.out.println("==========================");
            System.out.println(c.getComment());
        });
    }
}