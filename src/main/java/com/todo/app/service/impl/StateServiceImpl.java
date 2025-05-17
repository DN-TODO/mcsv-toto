package com.todo.app.service.impl;

import com.todo.app.model.State;
import com.todo.app.repository.IStateRepository;
import com.todo.app.service.IStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements IStateService {
    private final IStateRepository stateRepository;

    @Override
    @Transactional
    public Mono<State> save(State entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());        
        return stateRepository.save(entity);
    }

    @Override
    @Transactional
    public Mono<State> update(Long id, State entity) {
        return stateRepository.findById(id)
                .flatMap(existing -> {
                    BeanUtils.copyProperties(entity, existing, new String[]{"idState","createdAt","updatedAt"});
                    existing.setUpdatedAt(LocalDateTime.now());
                    return stateRepository.save(existing);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<State> findById(Long id) {
        return stateRepository.findById(id);
    }

    @Override
    @Transactional
    public Mono<State> delete(Long id) {
        return stateRepository.findById(id)
                .flatMap(existing -> stateRepository.delete(existing).thenReturn(existing));
    }
}
