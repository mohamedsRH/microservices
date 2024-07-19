package com.microservices.libraraymicroservice.event;

import com.commons.commonlib.dto.LibraryDTO;
import com.microservices.libraraymicroservice.mapper.LibraryMapper;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryEventHandler {
    private final LibraryRepository libraryRepository;

    public void handleLibraryCreatedEvent(LibraryDTO libraryDTO) {
        Library entity = LibraryMapper.toEntity(libraryDTO);
        libraryRepository.save(entity);
    }

    public void handleLibraryUpdatedEvent(LibraryDTO libraryDTO) {
        Library entity = LibraryMapper.toEntity(libraryDTO);
        libraryRepository.save(entity);
    }

    public void handleLibraryDeletedEvent(String id) {
        libraryRepository.deleteById(id);
    }
}