package com.dogukan.repository;

import com.dogukan.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository implements IStudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        Transaction trc = session.beginTransaction();
        List<Student> studentList = session.createQuery("from Student", Student.class).getResultList();
        trc.commit();
        session.close();
        return studentList;
    }

    @Override
    public void saveOrUpdate(Student student) {
        Session session = sessionFactory.openSession();
        Transaction trc = session.beginTransaction();
        //insert into
        session.saveOrUpdate(student);//dbde eger deger varsa update ediyor yoksa yani obje olusturuyor
        trc.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }
    //optional cekme sebebi null point exception almamak icin.
}