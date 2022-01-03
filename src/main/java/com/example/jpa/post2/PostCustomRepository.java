package com.example.jpa.post2;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post2> findMyPost();

    void delete(T entity);
}
