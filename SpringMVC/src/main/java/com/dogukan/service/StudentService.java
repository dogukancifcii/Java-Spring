package com.dogukan.service;

import com.dogukan.domain.Student;
import com.dogukan.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository studentRepository;
    public List<Student> listAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void addOrUpdateStudent(Student student) {

    }

    @Override
    public Student findStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {

    }
}