package com.example.jpa.post4;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository4 extends JpaRepository<Post4, Long> {

    List<Post4> findByTitleStartsWith(String title);

    @Query("SELECT p FROM #{#entityName} AS p WHERE p.title = :title")
    List<Post4> findByTitle(@Param("title") String keyword, Sort sort);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post4 p SET p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String hibernate, Long id);


}
