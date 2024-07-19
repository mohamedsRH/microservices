package com.commons.commonlib.service;

public interface ICommandService<T, ID>{
    T save(T entity);
    T update(T entity);
    void deleteById(ID id);
}
