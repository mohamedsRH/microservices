package com.microservices.libraraymicroservice.controller;

import com.commons.commonlib.controller.BaseController;
import com.commons.commonlib.controller.BaseQueryController;
import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.dto.LibraryDTO;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libraries")
public class LibraryController extends BaseQueryController<LibraryDTO,String> {
    LibraryService libraryService;
    protected LibraryController(LibraryService libraryService) {

        super ( libraryService );
        this.libraryService = libraryService;
    }
    @GetMapping("/sync/{id}")
    LibraryDTO findByIdSync(@PathVariable String id){
        return libraryService.findByIdSync ( id );
    }
}
