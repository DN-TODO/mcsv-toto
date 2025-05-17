package com.todo.app.repository;

import com.todo.app.model.DetailTask;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailTaskRepository extends ReactiveCrudRepository<DetailTask, Long> {
}
