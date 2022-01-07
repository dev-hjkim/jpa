package com.example.jpa.post2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostRepository2 postRepository2;

    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable("id") Post2 post2) {
        return post2.getTitle();
    }

    // 옛날 버전, 에러남!
//    @GetMapping("/posts")
//    public PagedResources<Post2> getPosts(Pageable pageable, PagedResourcesAssembler assembler) {
//        return assembler.toResource(postRepository2.findAll(pageable));
//    }

    @GetMapping("/posts")
    public PagedModel<EntityModel<Post2>> getPosts(Pageable pageable, PagedResourcesAssembler assembler) {
        return assembler.toModel(postRepository2.findAll(pageable));
    }
}
