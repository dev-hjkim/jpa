package com.example.jpa;

import com.example.jpa.book.CustomRepository;
import com.example.jpa.book.CustomRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
//@EnableJpaRepositories(repositoryImplementationPostfix = "Default", repositoryBaseClass = SimpleMyRepository.class)
//@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
//@EnableAsync
//@Import(BeanRegistrar.class)
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

}
