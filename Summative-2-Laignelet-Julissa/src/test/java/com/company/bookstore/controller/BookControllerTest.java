package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.models.Author;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper  mapper = new ObjectMapper();

    @MockBean
    private BookRepository bookRepository;

    Book book = new Book();
    @BeforeEach
    public void setUp() {
        Publisher publisher = new Publisher();
        publisher.setEmail("famous@gmail.com");
        publisher.setPhone("201-213-0657");
        publisher.setCity("Fort Lee");
        publisher.setState("New Jersey");
        publisher.setPostalCode("07456");
        publisher.setName("Penguin House");

        Author author = new Author();
        author.setFirstName("Stephanie");
        author.setLastName("Perkins");
        author.setCity("Atlanta");
        author.setState("Georgia");
        author.setPostalCode("54647");
        author.setPhone("451-765-8765");
        author.setEmail("perkins@writers.com");

        book.setIsbn("10ave");
        book.setPublishDate("October 31, 2022");
        book.setPrice(12.99);
        book.setTitle("Live your life");
        book.setAuthor(author);
        book.setPublisher(publisher);
    }

    @Test
    public void addBookTest() throws Exception {
        when(bookRepository.save(any(Book.class))).thenReturn(book);
    }

    
}
