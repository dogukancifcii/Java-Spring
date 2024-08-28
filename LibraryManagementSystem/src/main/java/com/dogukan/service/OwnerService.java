package com.dogukan.service;


import com.dogukan.domain.Owner;
import com.dogukan.dto.OwnerDTO;

import com.dogukan.exceptions.ConflictException;
import com.dogukan.exceptions.OwnerNotFoundException;
import com.dogukan.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;


    public void saveOwner(OwnerDTO ownerDTO) {

        boolean existsByEmail = ownerRepository.existsByEmail(ownerDTO.getEmail());

        if (existsByEmail) {
            throw new ConflictException("This Email is Exist : " + ownerDTO.getEmail());
        }
        //Owner newOwner = new Owner();

        /*newOwner.setName(ownerDTO.getName());
        newOwner.setLastName(ownerDTO.getLastName());
        newOwner.setPhone(ownerDTO.getPhone());
        newOwner.setEmail(ownerDTO.getEmail());*/

        //yukaridaki uzun uzun yazmak yerine assagidaki gibi owner icine const metodu kullanabiliriz.
        Owner newOwner = new Owner(ownerDTO);
        ownerRepository.save(newOwner);

    }

    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() -> new OwnerNotFoundException("Uye bulunamadi id: " + id));
    }
}
