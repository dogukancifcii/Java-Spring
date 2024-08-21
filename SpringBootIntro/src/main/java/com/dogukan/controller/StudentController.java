package com.dogukan.controller;

import com.dogukan.domain.Student;
import com.dogukan.dto.StudentDTO;
import com.dogukan.dto.UpdateStudentDTO;
import com.dogukan.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

//responsebody:metodun donus degerini JSON formatinda cevap olarak hazirlar
@RestController
//bu classta Restful servisler yazilacak, requestlere karsilik responseler olusturacak.Controller anatasyonunun ozellesmis halidir.
/*"RESTful" terimi, Representational State Transfer (REST) mimari tarzına uygun olarak tasarlanmış web servislerini ifade eder. RESTful web servisleri, HTTP protokolü üzerinden veri iletimi yapar ve genellikle basit, stateless (durumsuz) işlemler sunar.*/
@RequestMapping("/students")//http://localhost:8080/students/...
@RequiredArgsConstructor
//assagidaki final keywordlu StudentService icin parametreli constructor olusturup const enjection yapmasini sagladi.Boyle yapinca @Autowired yazmamiza gerek kalmadi.
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

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
    public ResponseEntity<List<Student>> listAllStudents() { //responseEntity verme sebebimiz Http Status olarak 200 alabilmek icin.hem datalari hemde status kod icin ResponseEntity kullandik
        //tablodan tum ogrencileri getirelim
        List<Student> studentList = service.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK); //200
    }

    //Response entity : body + status kodu
    //jackson : objeler --> JSON formatina mapler
    //          JSON formati --> obje

    //3-öğrenci ekleme : CREATE
    //Request : http://localhost:8080/students + POST + body(JSON)

    //body(JSON):
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
    //@RequestBody : Postmandeki JSON formatini alip Studenta cevirecek.Postmande JSON formatinda yazdigimiz yer requestbody oluyor.
    //jackson:bodydeki JSON formatını --> Student objesine dönüştürüyor
    // @ResponseBody--RestController içinde var, bu sebeple gerek kalmadı!!!
    //valid anatasyonu Student Entityde koydugunuz sartlari karsiliyormu diye kontrol ediyor
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student) {
        service.saveStudent(student);

        return new ResponseEntity<>("Student is created successfully...", HttpStatus.CREATED);//201
    }

    //5-query param ile id si verilen öğrenciyi getirme
    //request: http://localhost:8080/students/query?id=1 + GET
    //response: student + 200
    @GetMapping("/query")
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id) {
        Student student = service.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);//200
    }

    //Odev:(Alternatif)5-path param ile id si verilen öğrenciyi getirme
    //request: http://localhost:8080/students/1 + GET
    //response: student + 200
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = service.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);//200
    }

    //7-path param ile id si verilen öğrenciyi silme
    //request: http://localhost:8080/students/1 + DELETE
    //response : basarili mesaj + 200
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudentById(id);
        //return new ResponseEntity<>("Student is deleted successfully", HttpStatus.OK); //200
        return ResponseEntity.ok("Student is deleted successfully"); //yukaridakinin ayni yazimi aslinda sadece cok kullanildigi icin static methodunu yapmislar.
    }

    //9-path param ile id si verilen ogrenciyi guncelleme:name,lastName,email
    //request: http://localhost:8080/students/1 + PUT/PATCH + BODY(JSON)
    //response : basarili mesaj + 201
    //bilgilerin bir kismi guncellenecekse PATCH eger tamamini guncelleyeceksek PUT metodunu kullaniyoruz
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @Valid @RequestBody UpdateStudentDTO studentDTO) {//dogrudan entity objesine degil DTO objesine koyuyoruz ki guvenlik ve hiz acisindan servis katmanina kadar dto tasiyor.

        service.updateStudent(id, studentDTO);

        return new ResponseEntity<>("Student is updated successfully", HttpStatus.CREATED);//201
    }

    //11-tum ogrencileri listeleme: READ
    //tum kayitlari page page (sayfa sayfa) gosterelim
    //request :
    //http://localhost:8080/students/page?
    //                               page=1&
    //                               size=10&
    //                               sort=name&
    //                               direction=DESC(ASC) + GET

    // 1 | 2 | 3 | 4 ......

    @GetMapping("/page")
    public ResponseEntity<Page<Student>> getAllStudentsByPage(@RequestParam("page") int pageNo, @RequestParam("size") int size, @RequestParam("sort") String property, @RequestParam("direction") Sort.Direction direction) {

        Pageable pageable = PageRequest.of(pageNo, size, Sort.by(direction, property));
        //findAll metodunun sayfa getirmesi icin gerekli olan bilgileri
        //pageable tipini verebiliriz.

        Page<Student> studentsPage = service.getAllStudentsPaging(pageable);

        return new ResponseEntity<>(studentsPage, HttpStatus.OK);
    }

    //13-grade ile ogrencileri filtreleyelim
    //request: http://localhost:8080/students/grade/100 + GET
    //response : 100 grade e sahip olan ogrenci listesi + 200
    @GetMapping("/grade/{grade}")
    public ResponseEntity<List<Student>> getAllStudentByGrade(@PathVariable Integer grade) {
        List<Student> studentList = service.getAllStudentByGrade(grade);
        return new ResponseEntity<>(studentList, HttpStatus.OK); //200
    }

    //ODEV:
    //JPA reponun hazir metodlari
    //JPQL/SQL ile custom sorgu
    //15-lastname ile öğrencileri filtreleyelim
    //request:http://localhost:8080/students/lastname?lastname=Potter + GET
    //response : lastname e sahip olan öğrenci listesi + 200
    @GetMapping("/lastname")
    public ResponseEntity<List<Student>> getAllStudentByLastName(@RequestParam("lastname") String lastName) {
        List<Student> studentList = service.getAllStudentByLastName(lastName);
        return new ResponseEntity<>(studentList, HttpStatus.OK); //200
    }

    //or kullanilacak
    //Meraklisina odev: isim veya soyisme gore filtreleme
    //request:http://localhost:8080/students/search?word=harry + GET
    //isim veya soyisim olunca ikisinden birini girince çıktı vermesıni isityoruz


    //17-id si verilen ogrencinin name, lastName ve grade getirelim
    //request:http://localhost:8080/students/info/2 + GET
    //response : id si verilen öğrencinin sadece 3 fieldını DTO ile + 200

    @GetMapping("/info/{id}")
    public ResponseEntity<StudentDTO> getStudentInfo(@PathVariable Long id) {

        //StudentDTO studentDTO = service.getStudentInfoById(id);
        StudentDTO studentDTO = service.getStudentInfoByDTO(id);


        logger.warn("-----servisten gelen DTO objesi----------"+studentDTO.getName());

        return ResponseEntity.ok(studentDTO); //200
    }

    //ÖDEVVV:) JPA reponun hazır metodunu türeterek veya
    //          JPQL ile custom sorgu yazarak
    //19-name içinde "al" hecesi geçen öğrencileri filtreleyelim: READ//ex:halil
    //http://localhost:8080/students/filter?word=al + GET
    @GetMapping("/filter")
    public ResponseEntity<List<Student>> getStudentInfo(@RequestParam String word) {

        List<Student> students = service.getStudentsSearching(word);

        return ResponseEntity.ok(students);//200

    }

    //21- //http://localhost:8080/students/welcome + GET
    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request) {

        logger.info("welcome isteginin pathi: " + request.getServletPath());
        logger.info("welcome isteginin http metodu : " + request.getMethod());

        return "Welcome";
    }
}
