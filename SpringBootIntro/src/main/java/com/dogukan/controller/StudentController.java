package com.dogukan.controller;

import com.dogukan.domain.Student;
import com.dogukan.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //1-tum ogrencileri listeleyelim : READ
    //http://localhost:8080/students + GET
    //response: Tum ogrencilerin listesini + 200 : OK (Http Status Kodu)
    @GetMapping
    public ResponseEntity<List<Student>> listAllStudents() { //responseEntity verme sebebimiz Http Status olarak 200 alabilmek icin
        //tablodan tum ogrencileri getirelim
        List<Student> studentList = service.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK); //200
    }
}
