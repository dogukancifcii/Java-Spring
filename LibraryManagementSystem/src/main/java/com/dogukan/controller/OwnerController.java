package com.dogukan.controller;

import com.dogukan.domain.Owner;
import com.dogukan.dto.OwnerDTO;
import com.dogukan.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;


    //save an Owner
    //http://localhost:8080/owners/save + JSON + POST
    //return : message
    @PostMapping("/save")
    public ResponseEntity<String> saveOwner(@RequestBody OwnerDTO ownerDTO) {


        ownerService.saveOwner(ownerDTO);
        return new ResponseEntity<>("Uye basarili bir sekilde olusturuldu", HttpStatus.CREATED);
    }

    //find all owner
    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> ownerList = ownerService.getAll();

        return new ResponseEntity<>(ownerList, HttpStatus.OK);
    }

    //find an owner by id--odev
    //delete-update
}
