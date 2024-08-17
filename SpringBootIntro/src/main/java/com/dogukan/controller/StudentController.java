package com.dogukan.controller;

import com.dogukan.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //bu classta Restful servisler yazilacak, requestlere karsilik responseler olusturacak.
/*"RESTful" terimi, Representational State Transfer (REST) mimari tarzına uygun olarak tasarlanmış web servislerini ifade eder. RESTful web servisleri, HTTP protokolü üzerinden veri iletimi yapar ve genellikle basit, stateless (durumsuz) işlemler sunar.*/
@RequestMapping("/students")//http://localhost:8080/students/...
@RequiredArgsConstructor
//assagidaki final keywordlu StudentService icin parametreli constructor olusturup const enjection yapmasini sagladi.Boyle yapinca @Autowired yazmamiza gerek kalmadi.
public class StudentController {

    private final StudentService service;

    //Spring Bootu selamlama requesti
    //http://localhost:8080/students/great + GET
    @GetMapping("/great")
    public String great() {
        return "Hello Spring Boot";
    }
}
