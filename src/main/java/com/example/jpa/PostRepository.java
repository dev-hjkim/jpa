package com.example.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
//    JpaRepository<Post, Long> 나오기 이전
//    @PersistenceContext
//    EntityManager entityManger;
//
//    public Post add(Post post) {
//        entityManger.persist(post);
//        return post;
//    }
//
//    public void delete(Post post) {
//        entityManger.remove(post);
//    }
//
//    public List<Post> findAll() {
//        return entityManger.createQuery("SELECT p FROM Post as p", Post.class)
//                .getResultList();
//    }

    Page<Post> findByTitleContains(String title, Pageable pageable);

    long countByTitleContains(String title);
}
