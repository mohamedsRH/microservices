package com.microservices.bookmicroservice.event;

import com.commons.commonlib.dto.BookDTO;
import com.microservices.bookmicroservice.mapper.BookMapper;
import com.microservices.bookmicroservice.model.Book;
import com.microservices.bookmicroservice.repository.BookRepository;
import com.microservices.bookmicroservice.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookEventHandler {
    private final BookRepository bookRepository;

    public void handleBookCreatedEvent(BookDTO bookDTO) {
        Book entity = BookMapper.toEntity(bookDTO);
        bookRepository.save(entity);
    }

    public void handleBookUpdatedEvent(BookDTO bookDTO) {
        Book entity = BookMapper.toEntity(bookDTO);
        bookRepository.save(entity);
    }

    public void handleBookDeletedEvent(long id) {
        bookRepository.deleteById(id);
    }
}