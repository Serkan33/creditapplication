package com.kocfinans.api.service;

import com.kocfinans.api.model.User;
import com.kocfinans.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class UserServiceImpl implements ServiceInterface<User> {

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


    public User findByCitizen(String citizenNumber) {
        Optional<User> user  = repository.findByCitizenNumber(citizenNumber);
        user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Kullanıcı bulunamadı"));
        return user.get();
    }

    @Transactional
    @Override
    public User save (User u){
        return repository.save(u);
    }

    @Override
    public UUID delete(UUID uuid) {
        User user = repository.getOne(uuid);
        repository.delete(user);
        return uuid;
    }

    @Transactional
    @Override
    public User update(User user) {

        return null;
    }
}
