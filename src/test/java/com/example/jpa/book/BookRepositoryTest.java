package com.example.jpa.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void test() {
//        Book book = new Book();
//        book.setTitle("spring");
//        book.setContent("data");
//        bookRepository.save(book);
//
//        assertEquals(1, bookRepository.findAll().size());
//
//        Optional<Book> ring = bookRepository.findOne(QBook.book.title.contains("ring"));
//        assertTrue(ring.isPresent());
//        Optional<Book> jpa = bookRepository.findOne(QBook.book.title.contains("jpa"));
//        assertTrue(jpa.isEmpty());

        Book book = new Book();
        book.setTitle("spring");
        book.setContent("data");
        Book newBook = bookRepository.save(book);

        assertTrue(bookRepository.contains(newBook));

        Optional<Book> ring = bookRepository.findOne(QBook.book.title.contains("ring"));
        assertTrue(ring.isPresent());
    }

}