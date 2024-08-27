package com.dogukan.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//1S-->MBook -->OneToMany
//MB-->1S  --->ManytoOne
@Entity
@Getter
@Setter
public class Book {//Many

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @JsonProperty("bookName")
    //sadece JSON formatinda fieldin belirtilen key ile gosterilmesini saglar
    private String name;

    @ManyToOne
    @JsonIgnore
    //bu fieldi JSON formatinda ignore at(gormezden gel)
    private Student student;
}
