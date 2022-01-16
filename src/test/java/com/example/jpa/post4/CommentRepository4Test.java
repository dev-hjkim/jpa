package com.example.jpa.post4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.example.jpa.post4.CommentSpecs.isBest;
import static com.example.jpa.post4.CommentSpecs.isGood;
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

    @Test
    public void specs() {
        Page<Comment4> page = commentRepository.findAll(isBest().and(isGood()), PageRequest.of(0, 10));
    }

    @Test
    public void qbe() {
        Comment4 prove = new Comment4();
        prove.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("up", "down");

        Example<Comment4> example = Example.of(prove, exampleMatcher);

        commentRepository.findAll(example);
    }
}