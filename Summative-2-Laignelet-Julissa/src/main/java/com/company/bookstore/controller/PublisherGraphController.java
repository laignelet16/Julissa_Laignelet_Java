package com.company.bookstore.controller;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;
import java.util.Optional;

public class PublisherGraphController {
    @Autowired
    PublisherRepository publisherRepository;

    // fetches all the publishers from the database, serialized as JSON
    @QueryMapping
    public List<Publisher> publishers() {
        return publisherRepository.findAll();
    }

    // finds the publisher through id argument in the database within publisherRepository
    @QueryMapping
    public Publisher findPublisherById(@Argument int id) {
        Optional<Publisher> returnVal = publisherRepository.findById(id);
        return returnVal.orElse(null);
    }

    // needs implementation of all fields to create publisher in publisherRepository
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
        Publisher newPublisher = new Publisher(id, name, street, city, state, postalCode, phone, email);
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
        //checks if the publisher already exists
        Publisher updatePublisher = publisherRepository.findById(id).orElseThrow();

        updatePublisher.setPublisherId(id);
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
}