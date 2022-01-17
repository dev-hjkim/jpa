package com.example.jpa.post4;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository4 extends JpaRepository<Comment4, Long>, JpaSpecificationExecutor<Comment4>, QueryByExampleExecutor<Comment4> {

    @EntityGraph(attributePaths = {"post"})
    Comment4 getById(Long id);

    @Transactional(readOnly = true) // flush를 NEVER로 설정하여 dirty checking을 막음 -> 성능 향상
    <T> List<T> findByPost_Id(Long id, Class<T> type);
}
