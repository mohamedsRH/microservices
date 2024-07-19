package com.microservices.bookmicroservice.service;

import com.commons.commonlib.dto.LibraryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "LIBRARAYMICROSERVICE/libraries")
public interface LibraryFeignClient {
    @GetMapping("/{id}")
    LibraryDTO getLibraryById(@PathVariable("id") String id);
}
