package com.microservices.bookmicroservice.mapper;

import com.microservices.bookmicroservice.dto.BookDTO;
import com.microservices.bookmicroservice.dto.LibraryDTO;
import com.microservices.bookmicroservice.model.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book, LibraryDTO libraryDTO) {
        if (book == null) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId ( book.getId () );
        bookDTO.setName(book.getName());
        bookDTO.setBookCategory(book.getBookCategory());
        bookDTO.setLibrary(libraryDTO);
        return bookDTO;
    }

    public static Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        Book book = new Book();
        book.setId (bookDTO.getId ());
        book.setName(bookDTO.getName());
        book.setBookCategory(bookDTO.getBookCategory());
        book.setLibraryId(bookDTO.getLibrary ().getId ());
        return book;
    }
}
