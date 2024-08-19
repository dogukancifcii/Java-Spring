package com.dogukan.controller;

import com.dogukan.domain.Task;
import com.dogukan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    //silme : //localhost:8080/TodoApp/tasks/delete/1 + GET
    // --> response:tum taskleri listeleyelim
    @GetMapping("/delete/{identity}")
    public String deleteTask(@PathVariable("identity") Long id) {
        service.deleteTask(id);
        return "redirect:/tasks";
    }

    //guncelleme : //localhost:8080/TodoApp/tasks/update?id=1 + GET

    @GetMapping("/update")
    public ModelAndView displayFormForUpdate(@RequestParam("id") Long identity) {

        Task foundTask = service.findTaskById(identity); //belirli iddeki taski getirme

        ModelAndView mav = new ModelAndView();
        mav.setViewName("taskForm"); //taskFrom.js sayfasi gelsin diyoruz
        mav.addObject("task", foundTask); //dbdeki belirle id deki taski alip form icine yarlestir demek.ilk yazdigimiz task kismi taskForm.js icindeki ModelAttribute icinde yaziyor

        return mav;
    }
}
