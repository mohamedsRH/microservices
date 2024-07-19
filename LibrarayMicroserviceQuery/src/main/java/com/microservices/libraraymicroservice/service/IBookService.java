package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.dto.BookDTO;

import java.util.List;

public interface IBookService {
    List<BookDTO> getBooksByILibraryId(String libraryId);
}
