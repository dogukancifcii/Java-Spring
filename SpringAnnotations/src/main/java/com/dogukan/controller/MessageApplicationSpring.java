package com.dogukan.controller;

import com.dogukan.AppConfiguration;
import com.dogukan.domain.Message;
import com.dogukan.service.MsgService;
import com.dogukan.service.SlackService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

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

        //MsgService service = context.getBean(MsgService.class); //newlemedik
        //getBean olarak paranet classi secersek otomatik olarak component olan child class gelir.Normalde interfaceden object olusturamiyoruz ama yukaridaki kullanimda interface yapabiliyoruz.1 den fazla component olursa senaryo farkli oluyor

        //service.sendMessage(message);

        //getBean methoduna parametre olarak parent verdik ancak birden fazla child(component olan) olsaydi ne yapardik?
        //MsgService service = context.getBean("insta_service",MsgService.class);
        //service.sendMessage(message);


        //bagimlilik varsa ne olur? //repositorye baglandigi icin bagimlilik var.
        //MsgService service = context.getBean("insta_service", MsgService.class); //insta_service'i newlemedik
        //service.saveMessage(message); //service repoya bagimli ama biz enjekte etmedik.
        //yani biz constructor olusturmadan spring kendisi enjeckte edip olusturdu.

        //eger FileRepository Classinada component eklenip springin yapmasini istersek isimlendirme yapmaliyiz. Yoksa 2 componentten birini secemiyor spring.Yani assagidaki gibi yapmaliyiz:
        // @Qualifier("fileRepository") //buradan fileRepositorye kaydet demis olduk.InstaService icine yazdik.


        //Random bir deger yazdiralim
        //Random rnd = new Random();
        //Random rnd = context.getBean(Random.class); //bu classta newleme islemi yapmadik
        //System.out.println(rnd.nextInt(100));
        //SlackService service = context.getBean(SlackService.class);
        //service.saveMessage(message);

        SlackService service1 =context.getBean(SlackService.class); //service1 isimli bir obje
        SlackService service2 =context.getBean(SlackService.class);//service2 isimli bir obje

        System.out.println(service1);
        System.out.println(service2);

        //Scope

        //default olarak singleton oluyor: bu classtan sadece bir tane obje uretiyor ve her seferinde bu objeyi cagiriyor!!!
        //bu olusturulan bean'in life cycle'ini Spring yonetir ve Spring sorumludur!!!

        //prototype olarak degistirebiliriz : bu ise classtan her cagrildiginda farkli bir obje uretmeyi saglar!!!
        //Beanlerin imhasindan Spring sorumlu degildir

        //prototype yapinca adressler farkli olur farkli olursa objelerde farkli olur.Default olarak singelton olunca referansta ayni oldugu icin tek ikiside ayni obje olmus olur.
        if (service1==service2){//== : hem referans hemde objenin degerini kontrol eder
            System.out.println("bu objeler aynidir!!!");
        }else {
            System.out.println("bu objeler ayni degildir!!!");
        }
//
    }
}
