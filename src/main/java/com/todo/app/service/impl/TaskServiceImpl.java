package com.todo.app.service.impl;

import com.todo.app.model.Task;
import com.todo.app.repository.ITaskRepository;
import com.todo.app.service.ITaskService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Transactional
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {
    private final ITaskRepository taskRepository;

    @Override
    public Mono<Task> save(Task entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(entity);
    }

    @Override
    public Mono<Task> update(Long id, Task entity) {
        return taskRepository.findById(id)
                .flatMap(existing -> {
                    BeanUtils.copyProperties(entity, existing, new String[]{"idTask,", "createdAt", "updatedAt"});
                    existing.setUpdatedAt(LocalDateTime.now());
                    return taskRepository.save(existing);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public Mono<Task> delete(Long id) {
        return taskRepository.findById(id)
                .flatMap(existing -> taskRepository.delete(existing).thenReturn(existing));
    }
}
