package com.dogukan.service;

import com.dogukan.domain.Student;
import com.dogukan.exception.ConflictException;
import com.dogukan.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //constructor injection 1 tane constructor oldugu icin Autorwired yazmamiza gerek kalmadi.

/*public StudentService(StudentRepository repository) {
        this.repository = repository;
 }*/
public class StudentService {

    //burada yukaridaki RequiredArgsConstructor sayesinde const injection yapmis olduk.
    private final StudentRepository repository;

    //1-b
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    //4-ogrenciyi kaydetme
    public void saveStudent(Student student) {

        //student daha once tabloya eklenmis mi : tabloda ayni emaile sahip baska student var mi ?
        //SELECT * FROM student WHERE email = student.getEmail()-->t/f

        if (repository.existsByEmail(student.getEmail())) {
            //bu email daha once kullanilmis -- >hata firlatalim
            throw new ConflictException("Email already exists!");
        }
        repository.save(student); //insert into...
    }
}
