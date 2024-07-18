package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.commons.commonlib.service.IBaseService;
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
public class LibraryService implements IBaseService<LibraryDTO,String> {

    private final LibraryRepository libraryRepository;
    private final IBookService bookRestTemplateService;

    @Override
    public List<LibraryDTO> findAll() {

        List<Library> libraries =  libraryRepository.findAll ();
        return libraries.stream ().map ( library -> LibraryMapper.toDTO ( library,null ) ).collect( Collectors.toList());
    }

    @Override
    public LibraryDTO findById(String id) {
        Optional<Library> library = libraryRepository.findById ( id );
        if(library.isPresent ()){

            List<BookDTO> bookDTOList = bookRestTemplateService.getBooksByILibraryId ( id );
            return LibraryMapper.toDTO ( library.get (),bookDTOList );
        }
        return null;
    }

    @Override
    public LibraryDTO save(LibraryDTO libraryDTO) {
        Library entity = LibraryMapper.toEntity ( libraryDTO );
        Library library = libraryRepository.save(entity);
        return LibraryMapper.toDTO ( library,null );
    }

    @Override
    public LibraryDTO update(LibraryDTO libraryDTO) {
        Library entity = LibraryMapper.toEntity ( libraryDTO );
        Library library = libraryRepository.save ( entity );
        return LibraryMapper.toDTO ( library,null );
    }

    @Override
    public void deleteById(String id) {
        libraryRepository.deleteById ( id  );
    }
}
