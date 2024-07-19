package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.commons.commonlib.event.Event;
import com.commons.commonlib.event.EventType;
import com.commons.commonlib.event.LibraryEvent;
import com.commons.commonlib.service.IBaseService;
import com.commons.commonlib.service.ICommandService;
import com.microservices.libraraymicroservice.event.KafkaProducer;
import com.microservices.libraraymicroservice.mapper.LibraryMapper;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LibraryService implements ICommandService<LibraryDTO,String> {

    private final LibraryRepository libraryRepository;
    private final IBookService bookRestTemplateService;
    private final KafkaProducer kafkaProducer;

    @Override
    public LibraryDTO save(LibraryDTO libraryDTO) {
        Library entity = LibraryMapper.toEntity ( libraryDTO );
        Library library = libraryRepository.save(entity);
        LibraryDTO libraryDTO1 = LibraryMapper.toDTO ( library,null );
        kafkaProducer.produceEvent(new LibraryEvent(EventType.CREATED_LIBRARY_EVENT, libraryDTO1, LocalDateTime.now()));
        return libraryDTO1;

    }

    @Override
    public LibraryDTO update(LibraryDTO libraryDTO) {
        Library entity = LibraryMapper.toEntity ( libraryDTO );
        Library library = libraryRepository.save ( entity );
        LibraryDTO libraryDTO1 = LibraryMapper.toDTO ( library,null );
        kafkaProducer.produceEvent(new LibraryEvent(EventType.UPDATED_LIBRARY_EVENT, libraryDTO1, LocalDateTime.now()));
        return libraryDTO1;
    }

    @Override
    public void deleteById(String id) {
        Library entity = libraryRepository.findById(id).get();
        LibraryDTO libraryDTO = LibraryMapper.toDTO(entity,null);
        kafkaProducer.produceEvent(new LibraryEvent(EventType.DELETED_LIBRARY_EVENT, libraryDTO, LocalDateTime.now()));
        libraryRepository.deleteById ( id  );
    }
}
