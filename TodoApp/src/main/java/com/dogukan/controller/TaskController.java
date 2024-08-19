package com.dogukan.controller;

import com.dogukan.domain.Task;
import com.dogukan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Provider;
import java.util.List;


//request:url + HTTP method + body
@Controller
@RequestMapping("/tasks")
//localhost:8080/TodoApp/tasks/form + GET
//localhost:8080/TodoApp/tasks/enterTask + body(form) + POST --CREATE
//localhost:8080/TodoApp/tasks + GET                         --READ
//localhost:8080/TodoApp/tasks/delete/1 + GET
//localhost:8080/TodoApp/tasks/update?id=1 + GET
//------ BASE URL-------/
public class TaskController {

    @Autowired
    private TaskService service;

    //controller:modelandview(model ve goruntu sayfasının ısmı),
    // String -->goruntu sayfasinin ismi, redirect:tekrar baska bir requeste gonderebiliriz

    //form gostermemiz gerekiyor
    @GetMapping("/form")
    public String displayForm(@ModelAttribute("task") Task task) {
        return "taskForm";//WEB-INF/views/taskForm.jsp
    }

    //enterTask :...tasks/enterTask + POST  -->response:tum taskleri goster
    @PostMapping("/enterTask")
    public String createTask(@ModelAttribute("task") Task task) {

        service.enterTask(task);
        return "redirect:/tasks"; //Tum tasklerin istendigi requeste yonlendiriliyor.
    }

    //.../tasks + GET
    @GetMapping
    public ModelAndView getAllTasks() {
        List<Task> taskList = service.getAllTasks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tasks", taskList);
        modelAndView.setViewName("tasks");//tasks.jsp
        return modelAndView;
    }

    
}
