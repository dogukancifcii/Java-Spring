package com.dogukan.dto;

import com.dogukan.domain.Student;
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
public class StudentDTO {//Basit bir POJO Class


    @NotBlank(message = "name can not be blank!")//request anında doğrulama
    @Size(min = 2, max = 50, message = "name must be between 2 and 50")//request anında doğrulama
    private String name;

    @NotBlank(message = "lastname can not be blank!")//request anında doğrulama
    @Size(min = 2, max = 50, message = "lastname must be between 2 and 50")//request anında doğrulama
    private String lastName;

    @NotNull(message = "grade can not be null")
    private Integer grade;

    public StudentDTO(Student student) {
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.grade = student.getGrade();
    }


}
