package com.commons.commonlib.controller;
import com.commons.commonlib.service.ICommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseCommandController<T, ID> {
    private final ICommandService<T, ID> commandService;

    protected BaseCommandController(ICommandService<T, ID> commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T createdEntity = commandService.save(entity);
        return ResponseEntity.ok(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        T updatedEntity = commandService.update(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        commandService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}