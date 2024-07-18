package com.commons.commonlib.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class LibraryDTO {
    String id;
    String name;
    String location;
    List<BookDTO> books;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
