package com.commons.commonlib.service;

import java.util.List;

public interface IQueryService<T, ID>{
    List<T> findAll();
    T findById(ID id);
}
