package com.dogukan.service;

import com.dogukan.domain.Student;
import com.dogukan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> listAllStudent() {
        return studentRepository.findAll();
    }
}
