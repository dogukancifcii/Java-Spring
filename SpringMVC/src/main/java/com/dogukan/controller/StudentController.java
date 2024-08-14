package com.dogukan.controller;

import com.dogukan.domain.Student;
import com.dogukan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//gelen request(istek ve talep)leri bu class sayesinde karsılıyoruz ve ilgili methodlar ile mapleyerek cevaplıyoruz
@RequestMapping("/students")//http:localhost:8080/B256SpringMVC/students/....
public class StudentController {

    //gelen request(istek ve talep)leri bu class sayesinde karsılıyoruz ve ilgili methodlar ile mapleyerek cevaplıyoruz //http:localhost:8080/B256SpringMVC/students/....

    @Autowired
    private StudentService service;

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
    @GetMapping
    public ModelAndView getStudents() {
        ModelAndView mav = new ModelAndView();
        List<Student> listStudent = service.listAllStudent();
        mav.addObject("students", listStudent);//bilgiyi db'den alıcaz repo'ya baglanmamız lazım repo'ya baglanabilmek icin service classına ihtiyacim var
        mav.setViewName("students");
        return mav;
    }
}
