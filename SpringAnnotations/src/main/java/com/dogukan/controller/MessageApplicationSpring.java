package com.dogukan.controller;

import com.dogukan.AppConfiguration;
import com.dogukan.domain.Message;
import com.dogukan.service.MsgService;
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

        //MsgService service = context.getBean(SlackService.class); //newlemedik
        //service.sendMessage(message);

        MsgService service = context.getBean(MsgService.class); //newlemedik
        //getBean olarak paranet classi secersek otomatik olarak component olan child class gelir.Normalde interfaceden object olusturamiyoruz ama yukaridaki kullanimda interface yapabiliyoruz.1 den fazla component olursa senaryo farkli oluyor

        //service.sendMessage(message);

        //getBean methoduna parametre olarak parent verdik ancak birden fazla child(component olan) olsaydi ne yapardik?


    }
}
