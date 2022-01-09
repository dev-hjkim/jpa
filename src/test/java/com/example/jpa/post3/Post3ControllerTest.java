package com.example.jpa.post3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
public class Post3ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PostRepository3 postRepository;

    @Test
    public void getPost() throws Exception {
        Post3 post = new Post3();
        post.setTitle("jpa");
        postRepository.save(post);

        mockMvc.perform(MockMvcRequestBuilders.get("/posts3/" + post.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("jpa"));
    }

    @Test
    public void getPosts() throws Exception {
        Post3 post = new Post3();
        post.setTitle("jpa");
        postRepository.save(post);

        mockMvc.perform(MockMvcRequestBuilders.get("/posts3/")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", "created,desc")
                        .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value("1001"));
    }

    @Test
    public void getPostsHateoas() throws Exception {
        createPosts3();

        mockMvc.perform(MockMvcRequestBuilders.get("/posts3/hateoas/")
                        .param("page", "3")
                        .param("size", "10")
                        .param("sort", "created,desc")
                        .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.post3List[0].title").value("jpa"));
    }

    private void createPosts3() {
        int postsCount = 100;
        while (postsCount > 0) {
            Post3 post = new Post3();
            post.setTitle("jpa");
            postRepository.save(post);
            postsCount--;
        }
    }


}