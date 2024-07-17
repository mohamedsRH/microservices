package com.microservices.commonlib.controller;

import com.microservices.commonlib.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {
    private final BaseService<T> baseService;

    protected BaseController(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public List<T> getAll() {
        return baseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) {
        T entity = baseService.findById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return baseService.save(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable Long id, @RequestBody T entity) {
        return baseService.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        baseService.deleteById(id);
    }
}
