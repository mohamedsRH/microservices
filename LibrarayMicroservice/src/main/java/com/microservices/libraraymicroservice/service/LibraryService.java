package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.service.IBaseService;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibraryService implements IBaseService<Library,String> {

    private final LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll ();
    }

    @Override
    public Library findById(String id) {
        Optional<Library> library = libraryRepository.findById ( id );
        return library.get ();
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
    public void deleteById(String id) {
        libraryRepository.deleteById ( id  );
    }
}
