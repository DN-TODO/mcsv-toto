package com.todo.app.commos;

import reactor.core.publisher.Mono;

public interface ICrudCommons<T, ID> {

    public Mono<T> save(T entity);

    public Mono<T> update(ID id, T entity);

    public Mono<T> findById(ID id);

    public Mono<T> delete(ID id);


}
