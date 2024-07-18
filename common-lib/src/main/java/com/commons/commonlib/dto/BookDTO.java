package com.commons.commonlib.dto;

import lombok.Getter;

@Getter
public class BookDTO {
    Long id;
    String name;
    String bookCategory;
    LibraryDTO library;

    public void setName(String name) {
        this.name = name;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setLibrary(LibraryDTO library) {
        this.library = library;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
