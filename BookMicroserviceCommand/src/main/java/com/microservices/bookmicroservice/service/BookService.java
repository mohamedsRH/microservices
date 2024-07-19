package com.microservices.bookmicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.commons.commonlib.event.Event;
import com.commons.commonlib.event.EventType;
import com.microservices.bookmicroservice.event.KafkaProducer;
import com.microservices.bookmicroservice.mapper.BookMapper;
import com.microservices.bookmicroservice.model.Book;
import com.microservices.bookmicroservice.model.BookCategory;
import com.microservices.bookmicroservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookService implements IBookService{

    private final BookRepository bookRepository;
    private final KafkaProducer kafkaProducer;

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book entity = BookMapper.toEntity ( bookDTO );
        Book book = bookRepository.save ( entity );
        bookDTO.setId(book.getId());
        kafkaProducer.produceEvent(new Event(EventType.CREATED_BOOK_EVENT, bookDTO, LocalDateTime.now()));
        return bookDTO;
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        Optional<Book> entity = bookRepository.findById ( bookDTO.getId () );
        entity.get ().setName ( bookDTO.getName () );
        entity.get ().setBookCategory ( BookCategory.valueOf ( bookDTO.getBookCategory () ) );
        entity.get ().setLibraryId ( bookDTO.getLibrary ().getId () );
        Book book = bookRepository.save ( entity.get () );
        BookDTO bookDTO1 = this.mapToBookDTO ( book );
        kafkaProducer.produceEvent(new Event(EventType.UPDATED_BOOK_EVENT, bookDTO1, LocalDateTime.now()));
        return bookDTO1;
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id).get();
        BookDTO bookDTO = mapToBookDTO(book);
        kafkaProducer.produceEvent(new Event(EventType.DELETED_BOOK_EVENT, bookDTO, LocalDateTime.now()));
        bookRepository.deleteById ( id );
    }

    private BookDTO mapToBookDTO(Book book){
        return BookMapper.toDTO ( book,null );
    }
}
