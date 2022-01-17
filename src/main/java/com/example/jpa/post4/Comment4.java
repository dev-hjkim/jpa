package com.example.jpa.post4;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

//@NamedEntityGraph(name="Comment4.post", attributeNodes=@NamedAttributeNode("post"))
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment4 {
    @GeneratedValue
    @Id
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post4 post;

    private int up;

    private int down;

    private boolean best;

    @CreatedDate
    private ZonedDateTime created;

    @CreatedBy
    @ManyToOne
    private Account4 createdBy;

    @LastModifiedDate
    private ZonedDateTime updated;

    @LastModifiedBy
    @ManyToOne
    private Account4 updatedBy;

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public boolean isBest() {
        return best;
    }

    public void setBest(boolean best) {
        this.best = best;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post4 getPost() {
        return post;
    }

    public void setPost(Post4 post) {
        this.post = post;
    }
}
