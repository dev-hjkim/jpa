package com.example.jpa.post2;

import org.springframework.context.ApplicationEvent;

public class PostPublishedEvent extends ApplicationEvent {

    private final Post2 post2;

    public PostPublishedEvent(Object source) {
        super(source);
        this.post2 = (Post2) source;
    }

    public Post2 getPost() {
        return post2;
    }
}
