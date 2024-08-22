package com.dogukan.domain;

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

    private String name;

    @ManyToOne
    private Student student;
}
