package com.example.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post = new Post();
//        post.setTitle("Spring Data JPA");
//
//        Comment comment = new Comment();
//        comment.setCommnet("1234");
//        post.addComment(comment);
//
//        Comment comment2 = new Comment();
//        comment2.setCommnet("5678");
//        post.addComment(comment2);

        Session session = entityManager.unwrap(Session.class);

        //        session.save(post);

        Post post = session.get(Post.class, 1L);
        System.out.println("================");
        System.out.println(post.getTitle());

//        Comment comment = session.get(Comment.class, 2L);
//        System.out.println("================");
//        System.out.println(comment.getCommnet());
//        System.out.println(comment.getPost().getTitle());

//        Post post = session.get(Post.class, 1L);
//        System.out.println("================");
//        System.out.println(post.getTitle());
//        post.getComments().forEach(c -> {
//            System.out.println("----------------");
//            System.out.println(c.getCommnet());
//        });
    }
}
