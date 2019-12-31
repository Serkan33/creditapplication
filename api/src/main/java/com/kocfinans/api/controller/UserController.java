package com.kocfinans.api.controller;

import com.kocfinans.api.model.User;
import com.kocfinans.api.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("credit")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl service;

    @GetMapping("users")
    public ResponseEntity<List<User>> findAll(){
        return  ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PostMapping("user/save")
    public ResponseEntity<User> save(@Valid @RequestBody User user){
        return ResponseEntity.created(null).body(service.save(user));
    }

    @GetMapping("user/{citizenNumber}")
    public User findByCitizenNumber(@PathVariable  String citizenNumber){
        return service.findByCitizen(citizenNumber);
    }
}
