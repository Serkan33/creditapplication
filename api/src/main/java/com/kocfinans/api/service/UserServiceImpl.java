package com.kocfinans.api.service;

import com.kocfinans.api.model.User;
import com.kocfinans.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByCitizen(String citizenNumber) {
        return repository.findByCitizenNumber(citizenNumber);
    }
}
