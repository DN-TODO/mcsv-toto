package com.todo.app.repository;

import com.todo.app.model.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends ReactiveCrudRepository<Task, Long> {
}
