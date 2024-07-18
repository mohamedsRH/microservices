package com.microservices.bookmicroservice.dto;

import com.microservices.bookmicroservice.model.BookCategory;
import lombok.Getter;

@Getter
public class BookDTO {
    Long id;
    String name;
    BookCategory bookCategory;
    LibraryDTO library;

    public void setName(String name) {
        this.name = name;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setLibrary(LibraryDTO library) {
        this.library = library;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
