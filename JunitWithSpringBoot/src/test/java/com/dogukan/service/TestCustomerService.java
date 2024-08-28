package com.dogukan.service;

import com.dogukan.domain.Customer;
import com.dogukan.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {

    //1-customerrepository objesi gerekli : mock
    @Mock
    private CustomerRepository customerRepository;

    //2-customerservice objesi gerekli
    @InjectMocks
    private CustomerService customerService;


    @Test
    void testGetCustomerById(){

        Customer customer=new Customer(1L,"Jack","Sparrow","JS");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.findById(99L)).thenReturn(Optional.empty());

        Customer actualCustomer=customerService.getCustomerById(1L);

        assertEquals(1L,actualCustomer.getId());
        assertThrows(RuntimeException.class,()->customerService.getCustomerById(99L));
        verify(customerRepository).findById(1L);
        verify(customerRepository).findById(99L);

    }


    @Test
    void testDeleteCustomer() {

    }
}
