package com.todo.app.controller;

import com.todo.app.dto.DetailTaskRequestDto;
import com.todo.app.mapper.DetailTaskMapper;
import com.todo.app.model.DetailTask;
import com.todo.app.service.IDetailTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/detail-task")
@RequiredArgsConstructor
public class DetailTaskController {
    private final IDetailTaskService detailTaskService;
    private final DetailTaskMapper detailTaskMapper;

    @PostMapping
    public Mono<ResponseEntity<DetailTask>> save(@RequestBody DetailTaskRequestDto entity) {
        DetailTask detailTask = detailTaskMapper.toEntity(entity);
        return detailTaskService.save(detailTask)
                .map(saved -> ResponseEntity.status(201).body(saved));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<DetailTask>> update(@PathVariable Long id, @RequestBody DetailTaskRequestDto entity) {
        DetailTask detailTask = detailTaskMapper.toEntity(entity);
        return detailTaskService.update(id, detailTask)
                .map(updated -> ResponseEntity.ok(updated))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<DetailTask>> findById(@PathVariable Long id) {
        return detailTaskService.findById(id)
                .map(found -> ResponseEntity.ok(found))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return detailTaskService.delete(id)
                .map(deleted -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
