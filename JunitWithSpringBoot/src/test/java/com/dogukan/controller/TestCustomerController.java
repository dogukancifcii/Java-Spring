package com.dogukan.controller;

import com.dogukan.domain.Customer;
import com.dogukan.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestCustomerController {

    //1-customer service objesi : mock
    @Mock
    private CustomerService customerService;
    //2-customer controller objesi
    @InjectMocks
    private CustomerController customerController;

    @Test
    void testGetCustomer() {

        Customer customer = new Customer(1L, "Jack", "Sparrow", "JS");

        when(customerService.getCustomerById(1L)).thenReturn(customer);

        ResponseEntity<Customer> actual = customerController.getCustomer(1L);

        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals(customer, actual.getBody());
        verify(customerService, times(1)).getCustomerById(1L);


    }

    @Test
    void testDeleteCustomer() {
        Customer customer = new Customer(1L, "Jack", "Sparrow", "JS");

        ResponseEntity<String> actual = customerController.deleteCustomer(1L);

        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals("Customer is deleted.", actual.getBody());
        verify(customerService, times(1)).deleteCustomer(1L);

    }
}
