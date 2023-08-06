/*
package com.company.bookstore.controller;
import com.company.bookstore.models.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorGraphController {
    @Autowired
    AuthorRepository authorRepository;

    // fetches all the authors from the database, serialized as JSON
    @QueryMapping
    public Author findAuthorById(@Argument int id) {
        Optional<Author> returnVal = authorRepository.findById(id);
        return returnVal.orElse(null);
    }

    // finds the author through id argument in the database within authorRepository
    @QueryMapping
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    // needs implementation of all fields to create author in authorRepository
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
}
*/
