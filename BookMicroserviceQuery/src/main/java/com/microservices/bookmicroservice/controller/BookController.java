package com.microservices.bookmicroservice.controller;

import com.commons.commonlib.controller.BaseCommandController;
import com.commons.commonlib.controller.BaseController;
import com.commons.commonlib.controller.BaseQueryController;
import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.service.IBaseService;
import com.microservices.bookmicroservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController extends BaseQueryController<BookDTO,Long> {
    private final BookService baseService;
    protected BookController(BookService baseService) {
        super ( baseService );
        this.baseService = baseService;

    }

    @GetMapping("/library/{id}")
    List<BookDTO> findBooksByLibraryId(@PathVariable String id){
        return baseService.findBooksByLibraryId ( id );
    }

    @GetMapping("/sync/{id}")
    BookDTO findByIdSync(@PathVariable Long id){
        return baseService.findByIdSync ( id );
    }

    @GetMapping("/sync")
    List<BookDTO> findBooksSync(){
        return baseService.findAllSync();
    }

}
