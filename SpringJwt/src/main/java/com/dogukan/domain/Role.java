package com.dogukan.domain;

import com.dogukan.domain.enums.RoleType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    //entityde enum kullandiysak belirtmeliyiz
    @Enumerated(EnumType.STRING)//enum sabitlerinin DB de String olarak kaydedilmesini saglar.
    @Column(nullable = false)
    private RoleType type; //ROLE_STUDENT, ROLE_ADMIN
}
