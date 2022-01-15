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
