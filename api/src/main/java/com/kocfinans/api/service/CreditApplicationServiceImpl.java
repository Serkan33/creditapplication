package com.kocfinans.api.service;

import com.kocfinans.api.model.CreditApplication;
import com.kocfinans.api.repository.CreditApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreditApplicationServiceImpl implements ServiceInterface<CreditApplication> {

    @Autowired
    CreditApplicationRepository repository;

    @Override
    public List<CreditApplication> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CreditApplication> findById(UUID id) {
        return repository.findById(id);
    }


    @Transactional
    @Override
    public CreditApplication save(CreditApplication creditApplication) {
        return repository.save(creditApplication);
    }

    @Override
    public UUID delete(UUID uuid) {
        Optional<CreditApplication> application = repository.findById(uuid);
        application.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kayıt bulunamadı"));
        return uuid;
    }

    @Override
    public CreditApplication update(CreditApplication creditApplication) {
        return null;
    }
}
