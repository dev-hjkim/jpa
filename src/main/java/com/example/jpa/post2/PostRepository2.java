package com.example.jpa.post2;

import com.example.jpa.MyRepository2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository2 extends MyRepository2<Post2, Long>, QuerydslPredicateExecutor<Post2> {
}
