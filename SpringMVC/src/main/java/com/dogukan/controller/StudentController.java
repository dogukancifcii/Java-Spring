package com.dogukan.controller;

import com.dogukan.domain.Student;
import com.dogukan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//gelen request(istek ve talep)leri bu class sayesinde karsılıyoruz ve ilgili methodlar ile mapleyerek cevaplıyoruz
@RequestMapping("/students")//http:localhost:8080/B256SpringMVC/students/....
public class StudentController {

    //gelen request(istek ve talep)leri bu class sayesinde karsılıyoruz ve ilgili methodlar ile mapleyerek cevaplıyoruz //http:localhost:8080/B256SpringMVC/students/....

    @Autowired
    private IStudentService service;

    //http:localhost:8080/B256SpringMVC/students/hi + get
    @GetMapping("/hi")
    public ModelAndView sayHi() { //response gonderiyoruz
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hi");
        mav.addObject("messagebody", "Ben Öğrenci Yönetim Sistemiyim");

        mav.setViewName("hi"); //view resolver /WEB-INF/views/hi.jsp
        return mav;
    }


    //1-tüm öğrencileri listeleme
    //http:localhost:8080/SpringMVC/students
    @GetMapping
    public ModelAndView getStudents() {//response
        ModelAndView mav = new ModelAndView();
        List<Student> listStudent = service.listAllStudent();
        mav.addObject("students", listStudent);//bilgiyi db'den alıcaz repo'ya baglanmamız lazım repo'ya baglanabilmek icin service classına ihtiyacim var
        mav.setViewName("students");
        return mav;
    }

    //2-öğrenciyi kaydetme
    //http:localhost:8080/B256SpringMVC/students/form    + get
    @GetMapping("/form")//request alıyor
    public String sendForm(@ModelAttribute("student") Student student) {//ModelAttribute kismi form kisminda yazan kisim studentForm.js icinde yer aliyor
        return "studentForm";
    }
    //ModelAttribute anatasyonu view katmani ile controller arasinda baglanti kurup bu baglanti ile model transferini saglar.Kullanicini girdigi degerleri atama iselmi yapiyor yani.
    //islem sonunda student'in firstname,lastname ve grade degerleri sirasiyla set edilmis oldu

    //2-a db'e gondermedik yani db kaydetme islemi

    //http:localhost:8080/B256SpringMVC/students/saveStudent
    //http:localhost:8080/B256SpringMVC/students/redirect:/students
    @PostMapping("/saveStudent") //saveStudents pathine gonderiyor
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        //bindingReseult sayesinde hatalari gostermemizi sagliyor.
        if (bindingResult.hasErrors()) {
            return  "studentForm";
        }
        service.addOrUpdateStudent(student);
        return "redirect:/students"; //students listesi pathine gonderme islemi
    }


    //3-mevcut ogrenciyi guncelleme
    //http:localhost:8080/SpringMVC/students/update?id=1 + get
    @GetMapping("/update")
    public ModelAndView sendFormForUpdate(@RequestParam("id")Long id){
        Student foundStudent=service.findStudentById(id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("student",foundStudent);
        mav.setViewName("studentForm");
        return mav;
    }

    //4-mevcut ogrenciyi silme
    //http:localhost:8080/SpringMVC/students/update?id=1 + get
}
