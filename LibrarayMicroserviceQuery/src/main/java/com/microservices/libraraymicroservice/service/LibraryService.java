package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.commons.commonlib.service.IBaseService;
import com.commons.commonlib.service.IQueryService;
import com.microservices.libraraymicroservice.mapper.LibraryMapper;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LibraryService implements ILibraryService {

    private final LibraryRepository libraryRepository;
    private final IBookService bookRestTemplateService;

    @Override
    public List<LibraryDTO> findAll() {
        List<Library> libraries =  libraryRepository.findAll ();
        return libraries.stream ().map ( library -> LibraryMapper.toDTO ( library ) ).collect( Collectors.toList());
    }

    @Override
    public LibraryDTO findById(String id) {
        Optional<Library> library = libraryRepository.findById ( id );
        if(library.isPresent ()){
            return LibraryMapper.toDTO ( library.get () );
        }
        return null;
    }

    @Override
    public LibraryDTO findByIdSync(String id) {
        Optional<Library> library = libraryRepository.findById ( id );
        if(library.isPresent ()){
            List<BookDTO> bookDTOList = bookRestTemplateService.getBooksByILibraryId ( id );
            library.get().setBooks(bookDTOList);
            return LibraryMapper.toDTO ( library.get () );
        }
        return null;
    }
}
