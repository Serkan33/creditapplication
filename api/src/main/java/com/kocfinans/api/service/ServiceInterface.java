package com.kocfinans.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceInterface<T> {

    List<T> findAll();
    Optional<T> findById(UUID id);
    T save(T t);
    UUID delete(UUID uuid);
    T update(T t);
}
