package com.example.jpa.post;

import com.example.jpa.post2.PostListener;
import com.example.jpa.post2.PostPublishedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {
//    @Bean
//    public PostListener postListener() {
//        return new PostListener();
//    }

    @Bean   // PostListener로 listener class 만들고 싶지 않을 때
    public ApplicationListener<PostPublishedEvent> postListener() {
        return event -> {
            System.out.println("--------------------");
            System.out.println(event.getPost().getTitle() + " is published!!");
            System.out.println("--------------------");
        };
    }
}

