package com.example.springpractice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookStoreTest {

    @Test
    void testName () {
        BookStore bookStore = new BookStore();
        bookStore.setLocation("Seattle");

        assertThat(bookStore.getLocation())
                .as("book store location")
                .isEqualTo("Seattle");

    }
}