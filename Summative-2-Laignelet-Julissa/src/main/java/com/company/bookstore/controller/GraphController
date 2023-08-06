package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.models.Author;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import javax.swing.text.html.Option;
import java.util.*;

@Controller
public class GraphController {

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @QueryMapping
    public Book findBookById(@Argument int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Book> findBooksByAuthorId(@Argument int authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    @QueryMapping
    public Author findAuthorById(@Argument int id) {
        return authorRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Publisher addPublisher (
            @Argument int id,
            @Argument String name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postalCode,
            @Argument String phone,
            @Argument String email
    ) {
        Publisher newPublisher = new Publisher(name, street, city, state, postalCode, phone, email);
        return publisherRepository.save(newPublisher);
    }

    @MutationMapping
    public Publisher updatePublisher(
            @Argument int id,
            @Argument String name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postalCode,
            @Argument String phone,
            @Argument String email
    ) {
        Publisher updatePublisher = publisherRepository.findById(id).orElseThrow();

        updatePublisher.setName(name);
        updatePublisher.setStreet(street);
        updatePublisher.setCity(city);
        updatePublisher.setState(state);
        updatePublisher.setPostalCode(postalCode);
        updatePublisher.setPhone(phone);
        updatePublisher.setEmail(email);
        return publisherRepository.save(updatePublisher);
    }

    @MutationMapping
    public void deletePublisherById(@Argument int id) {
        publisherRepository.deleteById(id);
    }

    @MutationMapping
    public Author addAuthor (
            @Argument int id,
            @Argument String firstName,
            @Argument String lastName,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postalCode,
            @Argument String phone,
            @Argument String email) {
        Author newAuthor = new Author(firstName, lastName, street, city, state, postalCode, phone, email);
        return authorRepository.save(newAuthor);
    }


    @MutationMapping
    public Author updateAuthor(
            @Argument int id,
            @Argument String firstName,
            @Argument String lastName,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postalCode,
            @Argument String phone,
            @Argument String email) {

        //checks if the author already exists
        Author updateAuthor = authorRepository.findById(id).orElseThrow();

        updateAuthor.setAuthorId(id);
        updateAuthor.setFirstName(firstName);
        updateAuthor.setLastName(lastName);
        updateAuthor.setStreet(street);
        updateAuthor.setCity(city);
        updateAuthor.setState(state);
        updateAuthor.setPostalCode(postalCode);
        updateAuthor.setPhone(phone);
        updateAuthor.setEmail(email);

        return authorRepository.save(updateAuthor);
    }

    @MutationMapping
    public void deleteAuthorById(@Argument int id) {
        authorRepository.deleteById(id);
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
