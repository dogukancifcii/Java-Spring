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
        Task task = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Task is not found by ID"));
        //burada optional olan yeri eger null dondururse yani olmayan id gelirse hata firlaticak
        return task;
    }

    public void deleteTask(Long id) {
        repository.delete(id);
    }

}
