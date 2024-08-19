package com.dogukan.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide a valid description!")
    @Size(max=150, message ="Please provide a valid length!" )
    @Column(length = 150,nullable = false)
    private String description;

    private LocalDate date=LocalDate.now();

    @Max(value = 5, message = "Level cannot be greater than 5!")
    @Min(value = 1, message = "Level cannot be lower than 1!")
    @NotNull(message ="Please provide a level!" )
    private Integer level;//1.2.3.4.5


    //getter-setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}