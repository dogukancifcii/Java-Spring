package com.dogukan.repository;

import com.dogukan.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Task task) {//save ve update metodunuda buradan kullanicaz

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //session.save(task);
        session.saveOrUpdate(task);//id ye gore tabloda varsa update,yoksa create islemi yapar.


        tx.commit();
        session.close();

    }


    public List<Task> getAll() {

        return null;
    }

    public Task findById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }
}
