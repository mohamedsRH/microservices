package com.microservices.bookmicroservice.repository;

import com.microservices.bookmicroservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findBooksByLibraryId(String id);
}
