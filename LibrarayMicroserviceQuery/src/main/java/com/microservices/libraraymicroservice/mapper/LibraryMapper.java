package com.microservices.libraraymicroservice.mapper;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.microservices.libraraymicroservice.model.Library;

import java.util.List;

public class LibraryMapper {
    public static LibraryDTO toDTO(Library library){
        if (library == null) {
            return null;
        }
        LibraryDTO libraryDTO = new LibraryDTO ();
        libraryDTO.setId ( library.getId () );
        libraryDTO.setLocation ( library.getLocation () );
        libraryDTO.setName ( library.getName () );
        libraryDTO.setBooks ( library.getBooks() );
        return libraryDTO;
    }
    public static Library toEntity(LibraryDTO libraryDTO ){
        if (libraryDTO == null) {
            return null;
        }
        Library library = new Library();
        library.setId ( libraryDTO.getId () );
        library.setLocation ( libraryDTO.getLocation () );
        library.setName ( libraryDTO.getName () );
        return library;
    }
}
