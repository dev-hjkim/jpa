package com.example.jpa.post4;


import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {

    String getComment();

    int getUp();

    int getDown();

    // closed projection
    default String getVotes() {
        return getUp() + " " + getDown();
    }

    // open projection
//    @Value("#{target.up + ' ' + target.down}")
//    String getVotes();
}
