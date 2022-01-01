package com.example.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long>{

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);

    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);

    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    Stream<Comment> findByCommentContainsIgnoreCase(String keyword);

    Optional<Comment> findByCommentContainsIgnoreCaseAndLikeCount(String keyword, int likeCount);
}
