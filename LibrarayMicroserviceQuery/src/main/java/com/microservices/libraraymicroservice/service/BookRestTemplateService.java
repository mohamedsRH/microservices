package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import lombok.AllArgsConstructor;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookRestTemplateService implements IBookService{

    @Autowired
    private  RestTemplate restTemplate;

    @Value("${books.api.url}")
    private String booksApiUrl;

    public List<BookDTO> getBooksByILibraryId(String libraryId){
        BookDTO[] booksResponse =restTemplate.getForObject (booksApiUrl+libraryId,BookDTO[].class);
        return booksResponse != null ? Arrays.asList(booksResponse) : null;
    }
}
