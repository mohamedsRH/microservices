package com.commons.commonlib.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseMongoRepository<T,ID> extends MongoRepository<T,ID> {
}
