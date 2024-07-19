package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class BookRestTemplateService implements IBookService{
    private static final String BOOKS_API_URL = "http://localhost:8181/books/library/";

    private final RestTemplate restTemplate;

    public List<BookDTO> getBooksByILibraryId(String libraryId){
        BookDTO[] booksResponse =restTemplate.getForObject (BOOKS_API_URL+libraryId,BookDTO[].class);
        return booksResponse != null ? Arrays.asList(booksResponse) : null;
    }
}
