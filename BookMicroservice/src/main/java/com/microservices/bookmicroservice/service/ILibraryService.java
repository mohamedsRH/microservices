package com.microservices.bookmicroservice.service;

import com.microservices.bookmicroservice.dto.LibraryDTO;

public interface ILibraryService {
    LibraryDTO getLibraryById(String id);
}
