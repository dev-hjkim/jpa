package com.example.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws ExecutionException, InterruptedException{
        this.createComment(100, "spring data jpa");
        this.createComment(55, "HIBERNATE SPRING");

        commentRepository.flush();

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("spring", 10);
        assertThat(comments.size()).isEqualTo(2);

        List<Comment> comments2 = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");
        assertThat(comments2.size()).isEqualTo(2);
        assertThat(comments2).first().hasFieldOrPropertyWithValue("likeCount", 100);


        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));
        Page<Comment> comments3 = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
        assertThat(comments3.getNumberOfElements()).isEqualTo(2);
        assertThat(comments3).first().hasFieldOrPropertyWithValue("likeCount", 100);

        try (Stream<Comment> comments4 = commentRepository.findByCommentContainsIgnoreCase("spring")) {
            Comment firstComment = comments4.findFirst().get();
            assertThat(firstComment.getLikeCount()).isEqualTo(100);
        }

        Optional<Comment> comments5 = commentRepository.findByCommentContainsIgnoreCaseAndLikeCount("spring", 10);
        assertThat(comments5).isEmpty();

        Comment comment6 = comments5.orElse(new Comment());
        assertThat(comment6.getLikeCount()).isEqualTo(0);

        ListenableFuture<List<Comment>> future =
                commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountAsc("spring");
        System.out.println("====================");
        System.out.println("is done?" + future.isDone());

//        List<Comment> comments6 = future.get();
//        comments6.forEach(System.out::println);

        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }

            @Override
            public void onSuccess(@Nullable List<Comment> result) {
                System.out.println("===== Async =====");
                System.out.println(result.size());    // 얘는 무조건 비어있음! 기존 스레드 data 변동 정보 tracking 못하므로
            }
        });

        Thread.sleep(5000);

    }

    private void createComment(int linkCount, String comment) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(linkCount);
        commentRepository.save(newComment);
    }

}