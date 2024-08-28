package com.dogukan.controller;

import com.dogukan.service.CustomerService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestCustomerController {

    //1-customer service objesi : mock
    @Mock
    private CustomerService customerService;
    //2-customer controller objesi
    @InjectMocks
    private CustomerController customerController;
}
