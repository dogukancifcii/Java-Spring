package com.dogukan.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter //tum fieldlar icin getter method
@Setter //tum fieldlar icin setter method
@AllArgsConstructor //tum parametrelerin oldugu const olusturma
@NoArgsConstructor //parametresiz const olusturma
//@RequiredArgsConstructor:final ile isaretlenen fieldlari parametre olarak alan constructor
/*
    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

 */
@Entity
public class Student {//One

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //Id setter methodunu iptal etmis olduk
    private Long id;

    @NotBlank(message = "Name can not be blank") //request aninda dogrulama yapar
    @Size(min = 2, max = 50, message = "name must be between 2 and 50")//Size karakter icin kullanilir.
    @Column(nullable = false)
    /*final*/ private String name;

    @NotBlank(message = "Name can not be blank") //request aninda dogrulama yapar
    @Size(min = 2, max = 50, message = "name must be between 2 and 50")//Size karakter icin kullanilir.
    @Column(nullable = false)
    /*final*/ private String lastName;

    @NotNull(message = "grade can not be null")//notBlank ve NotEnty sayisal degerde kullanilamaz
    @Column(nullable = false)
    private Integer grade;

    @Column(unique = true)
    @Email(message = "please provide valid email!")//aa@bbb.ccc email formatinda olmasini dogrular
    //@Pattern()
    private String email;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate = LocalDateTime.now();

   // @OneToMany(mappedBy = "student")
    //private List<Book> bookList =new ArrayList<>(); //Many

    //getter-setter: boilerplate code
}
