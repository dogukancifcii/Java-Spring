package com.dogukan.repository;

import com.dogukan.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

        Session session = sessionFactory.openSession();

        List<Task> taskList = session.createQuery("FROM Task", Task.class).getResultList();

        session.close();

        return taskList;
    }

    public Optional<Task> findById(Long id) {
        Session session = sessionFactory.openSession();
        Task task = session.get(Task.class, id); //olmayan id ile null deger dondurur

        Optional<Task> optional = Optional.ofNullable(task); //Dikkat icinden null cikabilir

        session.close();

        return optional;
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //id si verilen obje getirme
        Task task = session.load(Task.class, id);

        session.delete(task);

        tx.commit();
        session.close();
    }
}
