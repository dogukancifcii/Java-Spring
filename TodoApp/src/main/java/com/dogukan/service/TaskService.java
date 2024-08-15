package com.dogukan.service;

import com.dogukan.domain.Task;
import com.dogukan.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    @Autowired
    private TaskRepository repository;

    public void enterTask(Task task) {
        //manipulasyonlar
        repository.save(task);
    }

    public List<Task> getAllTasks() {
        //List<Task> taskList = repository.getAll();
        //return taskList;
        return repository.getAll();
    }

    public Task findTaskById(Long id) {
        return null;
    }

    public void deleteTask(Long id) {
        repository.delete(id);
    }

}
