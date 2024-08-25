package com.dogukan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {


    @NotBlank(message = "Kitap ismi bosluk olamaz")//null ve bosluk olamaz
    @NotNull(message = "Kitap ismi girilmelidir")
    private String title;


    @NotBlank(message = "Yazar ismi bosluk olamaz")
    @Size(min = 2, max = 30, message = "Yazar ismi(${validatedValue}) {min} ve {max} karakter arasinda olmalidir")
    private String author;

    private String publicationDate;
}
