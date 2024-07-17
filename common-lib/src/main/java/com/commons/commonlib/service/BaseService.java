package com.commons.commonlib.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T entity);

    T update(T entity);
    void deleteById(Long id);
}
