package com.microservices.bookmicroservice.repository;

import com.microservices.bookmicroservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
