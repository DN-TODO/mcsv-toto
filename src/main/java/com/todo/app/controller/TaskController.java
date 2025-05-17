package com.todo.app.controller;

import com.todo.app.dto.TaskRequestDto;
import com.todo.app.mapper.TaskMapper;
import com.todo.app.model.Task;
import com.todo.app.service.ITaskService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {
    private final ITaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public Mono<ResponseEntity<Task>> save(@RequestBody TaskRequestDto entity) {
        Task task = taskMapper.toEntity(entity);
        return taskService.save(task)
                .map(saved -> ResponseEntity.status(201).body(saved));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Task>> update(@PathVariable Long id, @RequestBody Task entity) {
        return taskService.update(id, entity)
                .map(updated -> ResponseEntity.ok(updated))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Task>> findById(@PathVariable Long id) {
        return taskService.findById(id)
                .map(found -> ResponseEntity.ok(found))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return taskService.delete(id)
                .map(deleted -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
