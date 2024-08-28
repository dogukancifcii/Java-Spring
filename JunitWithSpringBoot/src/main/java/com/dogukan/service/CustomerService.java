package com.dogukan.service;

import com.dogukan.domain.Customer;
import com.dogukan.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Lutfen gecerli bir Id giriniz" + id));

    }


    public void deleteCustomer(Long id) {

        getCustomerById(id);
        customerRepository.deleteById(id);
    }
}
