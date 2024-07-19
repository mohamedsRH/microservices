package com.microservices.libraraymicroservice.event;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.microservices.libraraymicroservice.mapper.LibraryMapper;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookEventHandler {
    private final LibraryRepository libraryRepository;

    public void handleBookCreatedEvent(BookDTO book) {
        System.out.println("Received book event: " + book);

        // Ensure the book object is not null and has a valid library ID
        if (book == null || book.getLibrary() == null || book.getLibrary().getId() == null) {
            System.err.println("Invalid book or library information");
            return;
        }

        // Find the library by its ID
        Optional<Library> optionalLibrary = libraryRepository.findById(book.getLibrary().getId());

        if (optionalLibrary.isPresent()) {
            Library library = optionalLibrary.get();

            // Ensure the book is not already in the library's book list
            if (library.getBooks().stream().noneMatch(b -> b.getId().equals(book.getId()))) {
                library.getBooks().add(book);
                libraryRepository.save(library);
                System.out.println("Book added to library: " + library);
            } else {
                System.out.println("Book already exists in library: " + library);
            }
        } else {
            System.err.println("Library with ID " + book.getLibrary().getId() + " not found");
        }
    }


    public void handleBookUpdatedEvent(BookDTO book) {
        Optional<Library> entity = libraryRepository.findById(book.getLibrary().getId());
        if(entity.isPresent()){
            entity.get().getBooks().add(book);
            libraryRepository.save(entity.get());
        }
    }

    public void handleBookDeletedEvent(String libraryId,Long id) {
        Optional<Library> entity = libraryRepository.findById(libraryId);
        if(entity.isPresent()){
            entity.get().getBooks().stream().filter(bookDTO -> !bookDTO.getId().equals(id));
            libraryRepository.save(entity.get());
        }
    }
}