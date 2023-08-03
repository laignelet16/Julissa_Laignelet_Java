package com.company.bookstore.repository;

import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    //    in-memory data store
    public BookRepository() {
        seedDataStore();
    }

    // stores two
    private void seedDataStore() {
        Book book1 = new Book(1, "McGraw-Hill", "Hollywood", "Los Angeles", "CA", "11100", "111-222-3333", "mcGrawHill@gmail.com");
    }

}

// seed file within resources --> data.sql