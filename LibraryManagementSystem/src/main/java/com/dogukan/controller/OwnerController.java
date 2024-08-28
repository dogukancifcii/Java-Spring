package com.dogukan.controller;

import com.dogukan.domain.Owner;
import com.dogukan.dto.OwnerDTO;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> saveOwner(@RequestBody OwnerDTO ownerDTO) {


        //ownerService.saveOwner(ownerDTO);
        return new ResponseEntity<>("Ute basarili bir sekilde olusturuldu", HttpStatus.CREATED);
    }

}
