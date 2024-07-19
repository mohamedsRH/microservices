package com.microservices.bookmicroservice.service;

import com.commons.commonlib.dto.BookDTO;
import com.commons.commonlib.service.IBaseService;
import com.commons.commonlib.service.ICommandService;
import com.commons.commonlib.service.IQueryService;
import com.microservices.bookmicroservice.model.Book;

import java.util.List;

public interface IBookService extends IQueryService<BookDTO,Long> {
    List<BookDTO> findBooksByLibraryId(String id);
}
