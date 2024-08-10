package com.dogukan.controller;

import com.dogukan.AppConfiguration;
import com.dogukan.domain.Message;
import com.dogukan.service.SlackService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageApplicationSpring {
    public static void main(String[] args) {
        Message message = new Message();
        message.setBody("Welcome Spring :)");

        //config classini okur ve componentscan ile componentlari(bizim olusturdugumuz classlarda) ve beanleri(bizim olusturmadigimiz classlarda) tarar
        //sadece 1 tane spring bean olusturur ve context atar ve hazir olarak bekletir
        //bean istendiginde gerekliyse icine bagimliligini enjekte eder gonderir.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        SlackService service = context.getBean(SlackService.class);
        service.sendMessage(message);
    }
}
