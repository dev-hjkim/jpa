package com.example.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);

    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);

    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    Stream<Comment> findByCommentContainsIgnoreCase(String keyword);

    Optional<Comment> findByCommentContainsIgnoreCaseAndLikeCount(String keyword, int likeCount);

    @Async
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCaseOrderByLikeCountAsc(String keyword);
}
