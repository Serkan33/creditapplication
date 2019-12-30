package com.kocfinans.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService<T> {

    List<T> findAll();
    Optional<T> findById(UUID id);
    Optional<T> findByCitizen(String citizenNumber);
}
