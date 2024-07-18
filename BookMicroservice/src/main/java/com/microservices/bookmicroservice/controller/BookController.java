package com.microservices.bookmicroservice.controller;

import com.commons.commonlib.controller.BaseController;
import com.commons.commonlib.dto.BookDTO;
import com.microservices.bookmicroservice.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
public class BookController extends BaseController<BookDTO,Long> {
    protected BookController(BookService bookService) {
        super ( bookService );
    }
}
