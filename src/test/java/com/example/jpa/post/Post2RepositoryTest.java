package com.example.jpa.post;

import com.example.jpa.post2.Post2;
import com.example.jpa.post2.PostRepository2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class Post2RepositoryTest {

    @Autowired
    PostRepository2 postRepository2;

    @Test
    public void crud() {
        Post2 post2 = new Post2();
        post2.setTitle("hibernate");

        assertThat(postRepository2.contains(post2)).isFalse();  // transient 상태
        postRepository2.save(post2);

        assertThat(postRepository2.contains(post2)).isTrue();  // persist 상태

        postRepository2.delete(post2);
        postRepository2.flush();    // db와 싱크
    }

}