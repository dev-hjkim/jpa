package com.example.jpa.post4;

import javax.persistence.*;
import java.util.Date;

@Entity
//@NamedQuery(name="Post4.findByTitle", query = "SELECT p FROM Post4 AS p WHERE p.title = ?1")  // 지저분해질 수 있음, repository로!
//@NamedNativeQuery
public class Post4 {
    @GeneratedValue
    @Id
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
