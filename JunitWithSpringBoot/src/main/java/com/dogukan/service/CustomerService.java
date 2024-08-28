package com.dogukan.service;

import com.dogukan.domain.Customer;
import com.dogukan.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Lutfen gecerli bir Id giriniz" + id));

    }

    
}
