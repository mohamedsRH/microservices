package com.microservices.libraraymicroservice.controller;

import com.commons.commonlib.controller.BaseController;
import com.microservices.libraraymicroservice.model.Library;
import com.microservices.libraraymicroservice.service.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/libraries")
public class LibraryController extends BaseController<Library,String> {
    protected LibraryController(LibraryService libraryService) {
        super ( libraryService );
    }
}
