package com.microservices.bookmicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.microservices.bookmicroservice.mapper.BookMapper;
import com.microservices.bookmicroservice.model.Book;
import com.microservices.bookmicroservice.model.BookCategory;
import com.microservices.bookmicroservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookService implements IBookService{

    private final BookRepository bookRepository;
    private final ILibraryService libraryService;

    @Override
    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll ();
        return books.stream().map ( this::mapToBookDTO ).collect( Collectors.toList());
    }

    @Override
    public BookDTO findById(Long id) {
        Optional<Book> book =  bookRepository.findById ( id );
        System.out.println ("book entity"+book.get ());
        System.out.println ("book dto"+this.mapToBookDTO ( book.get () ));
        return this.mapToBookDTO ( book.get () );
    }

    private BookDTO mapToBookDTO(Book book){
        LibraryDTO libraryDTO = libraryService.getLibraryById ( book.getLibraryId () );
        return BookMapper.toDTO ( book,libraryDTO );
    }

    @Override
    public List<BookDTO> findBooksByLibraryId(String id) {
        List<Book> books = bookRepository.findBooksByLibraryId ( id );
        return BookMapper.toDTOList ( books,null );
    }
}
