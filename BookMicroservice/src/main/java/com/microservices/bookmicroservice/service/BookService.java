package com.microservices.bookmicroservice.service;

import com.microservices.bookmicroservice.model.Book;
import com.microservices.bookmicroservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService implements com.commons.commonlib.service.IBaseService<Book>{

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll ();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById ( id ).get ();
    }

    @Override
    public Book save(Book entity) {
        System.out.println ("book :"+entity);
        return bookRepository.save ( entity );
    }

    @Override
    public Book update(Book entity) {
        return bookRepository.save ( entity );
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById ( id );
    }
}
