package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.service.IBaseService;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService implements IBaseService<Library> {

    private final LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll ();
    }

    @Override
    public Library findById(Long id) {
        return libraryRepository.findById ( String.valueOf ( id ) ).get ();
    }

    @Override
    public Library save(Library entity) {
        return libraryRepository.save(entity);
    }

    @Override
    public Library update(Library entity) {
        return libraryRepository.save ( entity );
    }

    @Override
    public void deleteById(Long id) {
        libraryRepository.deleteById (String.valueOf ( id )  );
    }
}
