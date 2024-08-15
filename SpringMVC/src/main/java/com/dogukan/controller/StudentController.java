package com.dogukan.controller;

import com.dogukan.domain.Student;
import com.dogukan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        if (bindingResult.hasErrors()){
            return  "studentForm";
        }
        service.addOrUpdateStudent(student);
        return "redirect:/students"; //students listesi pathine gonderme islemi
    }

}
