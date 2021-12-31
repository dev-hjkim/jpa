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
        Account account = new Account();
        account.setUsername("hjkim");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring data JPA");
//        study.setOwner(account);

        account.getStudies().add(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
//        entityManager.persist(account);
    }
}