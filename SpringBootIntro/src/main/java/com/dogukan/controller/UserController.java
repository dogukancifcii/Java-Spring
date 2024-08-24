package com.dogukan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //useri kaydetme:register
    //localhost:8080/register + POST + JSON
    @RequestMapping("/register")
    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserDTO) {



        return new ResponseEntity<>("User is registered successfully..", HttpStatus.CREATED); //201
    }

}
