package com.example.jpa.post4;

import javax.persistence.*;

//@NamedEntityGraph(name="Comment4.post", attributeNodes=@NamedAttributeNode("post"))
@Entity
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
