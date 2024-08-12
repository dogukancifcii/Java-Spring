package com.dogukan.service;

import org.springframework.stereotype.Component;

@Component
public class PrintService {
    private String email = "dogukan@gmail.com";

    private String phone = "99999999999";

    public void printContact() {
        System.out.println("e-mail : " + this.email);
        System.out.println("phone : " + this.phone);
    }
}
