package com.dogukan.controller;

import com.dogukan.dto.UserRequest;
import com.dogukan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //useri kaydetme:register
    //localhost:8080/register + POST + JSON
    @RequestMapping("/register")
    @PostMapping
    public ResponseEntity<String> register(@Valid @RequestBody UserRequest userRequest) {

        userService.saveUser(userRequest);

        return new ResponseEntity<>("User is registered successfully..", HttpStatus.CREATED); //201
    }

}
