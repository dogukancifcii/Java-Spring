package com.dogukan.domain;


import com.dogukan.dto.OwnerDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Gecerli bir isim giriniz")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Gecerli bir soyad giriniz")
    @Column(nullable = false)
    private String lastName;

    private String phone;

    @Email(message = "Gecerli bir email giriniz")
    @Column(nullable = false, unique = true)
    private String email;

    @Setter(AccessLevel.NONE)
    private LocalDateTime registrationDate = LocalDateTime.now();

    @OneToMany(mappedBy = "owner")
    private List<Book> books = new ArrayList<>();

    public Owner(OwnerDTO ownerDTO) {
        this.name = ownerDTO.getName();
        this.lastName = ownerDTO.getLastName();
        this.phone = ownerDTO.getPhone();
        this.email = ownerDTO.getEmail();
    }
}
