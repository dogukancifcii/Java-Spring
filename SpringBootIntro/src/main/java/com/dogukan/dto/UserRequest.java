package com.dogukan.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter

public class UserRequest {

    @NotBlank //bunlari burada yazma sebebimiz client ile DTO classi baglanti kurdugu icin validation anatasyonlari burada kullanilir.
    private String firstName;

    @NotBlank
    private String userName;

    @NotBlank
    @Size(min = 8)
    private String password;


}
