package com.todo.app.service.impl;

import com.todo.app.model.DetailTask;
import com.todo.app.repository.IDetailTaskRepository;
import com.todo.app.service.IDetailTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DetailTaskServiceImpl implements IDetailTaskService {
    private final IDetailTaskRepository detailTaskRepository;

    @Override
    @Transactional
    public Mono<DetailTask> save(DetailTask entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());        
        return detailTaskRepository.save(entity);
    }

    @Override
    @Transactional
    public Mono<DetailTask> update(Long id, DetailTask entity) {
        return detailTaskRepository.findById(id)
                .flatMap(existing -> {
                    BeanUtils.copyProperties(entity, existing, new String[]{"idDetailTask, createdAt,updatedAt"});
                    existing.setUpdatedAt(LocalDateTime.now());
                    return detailTaskRepository.save(existing);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<DetailTask> findById(Long id) {
        return detailTaskRepository.findById(id);
    }

    @Override
    @Transactional
    public Mono<DetailTask> delete(Long id) {
        return detailTaskRepository.findById(id)
                .flatMap(existing -> detailTaskRepository.delete(existing).thenReturn(existing));
    }
}
