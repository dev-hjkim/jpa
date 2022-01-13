package com.example.jpa.post4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepository4Test {

    @Autowired
    private PostRepository4 postRepository;

    @PersistenceContext
    private EntityManager entityManager;

//    @Test
//    public void crud() {
//        Post4 post4 = new Post4();
//        post4.setTitle("jpa");
//        postRepository.save(post4); //JpaSystemException 발생
//
//        List<Post4> all = postRepository.findAll();
//        assertThat(all.size()).isEqualTo(1);
//    }

    @Test
    public void save() {
        Post4 post4 = new Post4();
        post4.setTitle("jpa");
        Post4 savedPost = postRepository.save(post4); // update 용도로 쓰일 수도 있음, 여기서는 insert 발생, entityManager.persist()
                                                      // persist(transient -> persistent)
        assertThat(entityManager.contains(post4)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(savedPost == post4);

        Post4 postUpdate = new Post4();
        postUpdate.setId(post4.getId()); // id가 있으므로 merge(detached -> persistent)
        postUpdate.setTitle("hibernate");
        Post4 updatedPost = postRepository.save(postUpdate); // 여기서 update 발생, entityManager.merge()

        assertThat(entityManager.contains(updatedPost)).isTrue();   // postUpdate의 복사본을 영속화시켜 리턴하므로 true
        assertThat(entityManager.contains(postUpdate)).isFalse();
        assertThat(updatedPost == postUpdate);

        updatedPost.setTitle("dev-hjkim");

        List<Post4> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }


    @Test
    public void findByTitleStartsWith() {
        savePost();

        List<Post4> all = postRepository.findByTitleStartsWith("spring");
        assertThat(all.size()).isEqualTo(1);
    }

    private void savePost() {
        Post4 post4 = new Post4();
        post4.setTitle("spring");
        postRepository.save(post4);
    }

    @Test
    public void findByTitle() {
        savePost();

//        List<Post4> all = postRepository.findByTitle("spring", Sort.by("title"));
        List<Post4> all = postRepository.findByTitle("spring", JpaSort.unsafe("LENGTH(title)"));
        assertThat(all.size()).isEqualTo(1);
    }

}