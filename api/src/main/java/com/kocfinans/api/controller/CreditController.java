package com.kocfinans.api.controller;

import com.kocfinans.api.model.User;
import com.kocfinans.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("credit")
public class CreditController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("users")
    public List<User> findAll(){
        return  service.findAll();
    }

}
