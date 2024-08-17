package com.dogukan.service;

import com.dogukan.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //constructor injection 1 tane constructor oldugu icin Autorwired yazmamiza gerek kalmadi.

/*public StudentService(StudentRepository repository) {
        this.repository = repository;
 }*/
public class StudentService {

    //burada yukaridaki RequiredArgsConstructor sayesinde const injection yapmis olduk.
    private final StudentRepository repository;


}
