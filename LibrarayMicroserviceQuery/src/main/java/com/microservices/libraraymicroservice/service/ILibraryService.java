package com.microservices.libraraymicroservice.service;

import com.commons.commonlib.dto.LibraryDTO;
import com.commons.commonlib.service.IQueryService;

import java.util.List;

public interface ILibraryService extends IQueryService<LibraryDTO,String> {
    LibraryDTO findByIdSync(String id);
}
