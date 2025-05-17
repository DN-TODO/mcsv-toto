package com.todo.app.controller;

import com.todo.app.dto.StateRequestDto;
import com.todo.app.dto.StateResponseDto;
import com.todo.app.mapper.StateMapper;
import com.todo.app.model.State;
import com.todo.app.service.IStateService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/state")
@AllArgsConstructor
public class StateController {
    private final IStateService stateService;
    private final StateMapper stateMapper;

    @PostMapping
    public Mono<ResponseEntity<State>> save(@RequestBody StateRequestDto entity) {
        State state = stateMapper.toEntity(entity);
        return stateService.save(state)
                .map(saved -> ResponseEntity.status(201).body(saved));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<State>> update(@PathVariable Long id, @RequestBody StateRequestDto entity) {
        State state = stateMapper.toEntity(entity);
        return stateService.update(id, state)
                .map(updated -> ResponseEntity.ok(updated))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<StateResponseDto>> findById(@PathVariable Long id) {
        return stateService.findById(id)
                .map(found -> {
                    StateResponseDto response = stateMapper.toResponse(found);
                    return ResponseEntity.ok(response);
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return stateService.delete(id)
                .map(deleted -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
