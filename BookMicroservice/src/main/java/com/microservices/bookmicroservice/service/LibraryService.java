package com.microservices.bookmicroservice.service;

import com.microservices.bookmicroservice.dto.LibraryDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryService implements ILibraryService{


    private final LibraryFeignClient libraryFeignClient;

    @CircuitBreaker ( name = "emptyLibrary",fallbackMethod = "fallbackEmptyLibrary")
    public LibraryDTO getLibraryById(String id) {
        return libraryFeignClient.getLibraryById ( id );
    }

    public LibraryDTO fallbackEmptyLibrary(String id,Throwable throwable)
    {
        return new LibraryDTO ();
    }
}
