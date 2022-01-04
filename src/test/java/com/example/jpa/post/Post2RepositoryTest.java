package com.example.jpa.post;

import com.example.jpa.post2.Post2;
import com.example.jpa.post2.PostPublishedEvent;
import com.example.jpa.post2.PostRepository2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest                                // slicing test, data 관련된 bean들만 등록되어 외부에서 @Component 아무리 달아도 bean 등록 되지 않는다
@Import(PostRepositoryTestConfig.class)     // 따라서 import 필요, 따로 bean 설정파일 작성
class Post2RepositoryTest {

    @Autowired
    PostRepository2 postRepository2;

//    @Autowired
//    ApplicationContext applicationContext;
//
//    @Test
//    public void event() {
//        Post2 post2 = new Post2();
//        post2.setTitle("event");
//        PostPublishedEvent event = new PostPublishedEvent(post2);
//
//        applicationContext.publishEvent(event);
//    }

    @Test
    public void crud() {
        Post2 post2 = new Post2();
        post2.setTitle("hibernate");

        assertThat(postRepository2.contains(post2)).isFalse();  // transient 상태
        postRepository2.save(post2.publish());

        assertThat(postRepository2.contains(post2)).isTrue();  // persist 상태

        postRepository2.delete(post2);
        postRepository2.flush();    // db와 싱크
    }

}