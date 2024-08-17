package com.dogukan.controller;

import com.dogukan.domain.Student;
import com.dogukan.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//responsebody:metodun donus degerini JSON formatinda cevap olarak hazirlar
@RestController //bu classta Restful servisler yazilacak, requestlere karsilik responseler olusturacak.
/*"RESTful" terimi, Representational State Transfer (REST) mimari tarzına uygun olarak tasarlanmış web servislerini ifade eder. RESTful web servisleri, HTTP protokolü üzerinden veri iletimi yapar ve genellikle basit, stateless (durumsuz) işlemler sunar.*/
@RequestMapping("/students")//http://localhost:8080/students/...
@RequiredArgsConstructor
//assagidaki final keywordlu StudentService icin parametreli constructor olusturup const enjection yapmasini sagladi.Boyle yapinca @Autowired yazmamiza gerek kalmadi.
public class StudentController {

    /*
    clienttan 3 şekilde data alabiliriz
    1-request body ile JSON formatında
    2-urlde path param
    3-urlde query param
     */

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
    // @ResponseBody--RestController içinde var, bu sebeple gerek kalmadı!!!
    public ResponseEntity<List<Student>> listAllStudents() { //responseEntity verme sebebimiz Http Status olarak 200 alabilmek icin
        //tablodan tum ogrencileri getirelim
        List<Student> studentList = service.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK); //200
    }

    //Response entity : body + status kodu
    //jackson : objeler --> JSON formatina mapler
    //          JSON formati --> obje

    //3-öğrenci ekleme : CREATE
    //Request : http://localhost:8080/students + POST + body(JSON)
    /*
    {
     "name":"Jack",
     "lastName":"Sparrow",
     "email":"jack@mail.com",
     "grade":98
    }
     */
    //response: başarılı mesaj + 201 (CREATED)
    @PostMapping
    //@RequestBody : requestin bodysini almamızı sağlar
    //jackson:bodydeki JSON formatını --> Student objesine dönüştürüyor
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student) {
        service.saveStudent(student);

        return new ResponseEntity<>("Student is created successfully...", HttpStatus.CREATED);
    }

}
