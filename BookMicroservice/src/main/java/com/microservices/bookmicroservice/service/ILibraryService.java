package com.microservices.bookmicroservice.service;

import com.commons.commonlib.dto.LibraryDTO;

public interface ILibraryService {
    LibraryDTO getLibraryById(String id);
}
