package com.microservices.commonlib.reposiory;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseMongoRepository<T,ID> extends MongoRepository<T,ID> {
}
