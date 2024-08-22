package com.dogukan.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //database'de null olamaz
    @NotBlank(message = "Kitap ismi bosluk olamaz")//null ve bosluk olamaz
    @NotNull(message = "Kitap ismi girilmelidir")
    private String title;


    @NotBlank(message = "Yazar ismi bosluk olamaz")
    @Size(min = 2, max = 30, message = "Yazar ismi(${validatedValue}) {min} ve {max} karakter arasinda olmalidir")
    @Column(nullable = false, length = 30)
    private String author;

    @Column(nullable = false)
    private String publicationDate;
}
