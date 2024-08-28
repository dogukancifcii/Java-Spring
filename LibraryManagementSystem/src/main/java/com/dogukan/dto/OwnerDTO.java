package com.dogukan.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class OwnerDTO {


    @NotBlank(message = "Gecerli bir isim giriniz")
    private String name;

    @NotBlank(message = "Gecerli bir soyad giriniz")
    private String lastName;

    private String phone;

    @Email(message = "Gecerli bir email giriniz")
    private String email;

}
