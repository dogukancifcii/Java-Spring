package com.dogukan.controller;

import com.dogukan.domain.Customer;
import com.dogukan.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    //read-delete

    //http://localhost:8080/customers/1 + GET
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable() Long id) {

        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(customer);
    }

    //http://localhost:8080/customers/1 + DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomer(id);

        return ResponseEntity.ok("Customer is deleted.");
    }

}
