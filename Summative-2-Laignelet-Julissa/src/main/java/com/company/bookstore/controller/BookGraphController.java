/*
package com.company.bookstore.controller;
import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
@Controller
public class BookGraphController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    // fetches all the books from the database, serialized as JSON
    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    // finds the book through id argument in the database within bookRepository
    @QueryMapping
    public Book findBookById(@Argument int id) {
        Optional<Book> returnVal = bookRepository.findById(id);
        return returnVal.orElse(null);
    }

    // needs implementation of all fields to create book in bookRepository
    @QueryMapping
    public List<Book> findBooksByAuthorId(@Argument int authorId) {
        List<Book> returnVal = bookRepository.findByAuthorId(authorId);
        if (returnVal.isEmpty()) {
            return returnVal;
        } else {
            return returnVal;
        }
    }

    @MutationMapping
    public Book addBook(
            @Argument int id,
            @Argument String isbn,
            @Argument String publishDate,
            @Argument Author author,
            @Argument String title,
            @Argument Publisher publisher,
            @Argument double price
    ) {
        //makes sures Author and publishers exist
        Author checkAuthor = authorRepository.findById(author.getAuthorId()).orElseThrow();
        Publisher checkPublisher = publisherRepository.findById(publisher.getPublisherId()).orElseThrow();

        Book newBook = new Book(isbn, publishDate, author, title, publisher, price);
        return bookRepository.save(newBook);
    }

    @MutationMapping
    public Book updateBook(
            @Argument int id,
            @Argument String isbn,
            @Argument String publishDate,
            @Argument int authorId,
            @Argument String title,
            @Argument int publisherId,
            @Argument double price
    ) {
        //makes sures Author and publishers exist
        Author author = authorRepository.findById(authorId).orElseThrow();
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow();
        Book updateBook = bookRepository.findById(id).orElseThrow();

        updateBook.setId(id);
        updateBook.setIsbn(isbn);
        updateBook.setPublishDate(publishDate);
        updateBook.setAuthor(author);
        updateBook.setTitle(title);
        updateBook.setPublisher(publisher);
        updateBook.setPrice(price);

        return bookRepository.save(updateBook);
    }

    @MutationMapping
    public void deleteBookById(@Argument int id) {
        bookRepository.deleteById(id);
    }
}
*/
