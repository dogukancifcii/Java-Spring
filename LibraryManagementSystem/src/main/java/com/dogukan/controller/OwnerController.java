package com.dogukan.controller;

import com.dogukan.domain.Owner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {


    //save an Owner
    //http://localhost:8080/owners/save + JSON + POST
    //return : message
    @PostMapping("/save")
    public ResponseEntity<String> saveOwner(@RequestBody Owner owner) {


        //ownerService.saveOwner(owner);
    }

}
