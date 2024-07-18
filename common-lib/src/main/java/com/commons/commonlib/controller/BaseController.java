package com.commons.commonlib.controller;

import com.commons.commonlib.service.IBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {
    private final IBaseService<T> baseService;

    protected BaseController(IBaseService<T> baseService) {
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
