package com.dogukan.service;

import com.dogukan.domain.Student;
import com.dogukan.exception.StudentNotFoundException;
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
        studentRepository.saveOrUpdate(student);
    }

    @Override
    public Student findStudentById(Long id) {
        Student foundStudent=studentRepository.findById(id).
                orElseThrow(()-> new StudentNotFoundException("Student not Found by ID : "+id));
        //findById methodu geriye optional dondurur
        //student varsa foundStudent objesine degeri atar
        //eger optional'in icin bosya elseThrow methodu bize olusturdugumuz exception'i firlatmayi saglar
        return foundStudent;
    }

    @Override
    public void deleteStudentById(Long id) {

    }
}