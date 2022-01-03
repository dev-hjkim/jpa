package com.example.jpa.post2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostCustomRepositoryDefault implements PostCustomRepository<Post2> {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post2> findMyPost() {
        System.out.println("custom findMyPost");
        return entityManager.createQuery("SELECT p FROM Post2 AS p", Post2.class)
                .getResultList();
    }

    @Override
    public void delete(Post2 entity) {
        System.out.println("custom delete");
        entityManager.remove(entity);
    }
}
