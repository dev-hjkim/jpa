package com.example.jpa.post3;

import com.example.jpa.post2.Post2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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

    @GetMapping("/posts3")
    public Page<Post3> getPosts(Pageable pageable) {
        return postRepository3.findAll(pageable);
    }

    @GetMapping("/posts3/hateoas")
    public PagedModel<EntityModel<Post3>> getPosts(Pageable pageable, PagedResourcesAssembler<Post3> assembler) {
        return assembler.toModel(postRepository3.findAll(pageable));
    }
}
