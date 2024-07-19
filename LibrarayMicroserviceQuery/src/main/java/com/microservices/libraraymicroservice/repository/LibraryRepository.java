package com.microservices.libraraymicroservice.repository;

import com.microservices.libraraymicroservice.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Library,String> {
}
