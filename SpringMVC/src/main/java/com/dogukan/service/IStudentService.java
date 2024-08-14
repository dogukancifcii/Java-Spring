package com.dogukan.service;

import com.dogukan.domain.Student;

import java.util.List;

public interface IStudentService {//Create + Update --read -- delete

    List<Student> listAllStudent();

    void addOrUpdateStudent(Student student);

    Student findStudentBy(Long id);

    void deleteStudentById(Long id);

}
