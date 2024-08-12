package com.dogukan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class PrintService {

    @Value("${email}")
    //value degisken ismini yazmamizi saglar application.properties kismindan degiskene gore cekiyor.Cekme ayarini AppConfiguration classi icinde @PropertiesSource anatasyonu icine yaziliyor.
    private String email;

    @Value("${phone}")
    private String phone;

    public void printContact() {
        System.out.println("e-mail : " + this.email);
        System.out.println("phone : " + this.phone);
    }

    @Autowired
    private Properties properties;

    public void getContact() { //map gibi bir yere koyulup cagirilmasini sagliyor.
        System.out.println("e-mail : " + properties.getProperty("mymail"));
        System.out.println("phone : " + properties.getProperty("myphone"));
    }
}
