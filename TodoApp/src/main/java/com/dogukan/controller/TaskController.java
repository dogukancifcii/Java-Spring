package com.dogukan.controller;

import com.dogukan.domain.Task;
import com.dogukan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Provider;


//request:url + HTTP method + body
@Controller
@RequestMapping("/tasks")
//localhost:8080/TodoApp/tasks/form + GET
//localhost:8080/TodoApp/tasks/enterTask + body(form) + POST
//localhost:8080/TodoApp/tasks + GET
//localhost:8080/TodoApp/tasks/delete/1 + GET
//localhost:8080/TodoApp/tasks/update?id=1 + GET
//------ BASE URL-------/
public class TaskController {

    @Autowired
    private TaskService service;

    //controller:modelandview,String

    //form gostermemiz gerekiyor
    @GetMapping("/form")
    public String displayForm(@ModelAttribute("task") Task task) {
        return "taskForm";//WEB-INF/views/taskForm.jsp
    }

    //enterTask
}
