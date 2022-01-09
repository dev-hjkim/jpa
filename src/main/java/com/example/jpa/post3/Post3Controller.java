package com.example.jpa.post3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Post3Controller {

    @Autowired
    private PostRepository3 postRepository3;

    @GetMapping("/posts3/{id}")
    public String getPost(@PathVariable("id") Post3 post) {
        return post.getTitle();
    }
}
