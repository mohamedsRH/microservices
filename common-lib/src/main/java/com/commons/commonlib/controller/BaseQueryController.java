package com.commons.commonlib.controller;
import com.commons.commonlib.service.IQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseQueryController<T, ID> {
    private final IQueryService<T, ID> queryService;

    protected BaseQueryController(IQueryService<T, ID> queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = queryService.findAll();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        T entity = queryService.findById(id);
        return ResponseEntity.ok(entity);
    }
}

