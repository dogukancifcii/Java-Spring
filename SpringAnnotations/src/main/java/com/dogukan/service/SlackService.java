package com.dogukan.service;

import com.dogukan.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component
//bu classın objelerini biz degil spring olusturacak(biz new ile olusturuyor idik paramiz yetmiyor) ve yoneticek ve objere Spring Bean denir
@Scope("prototype")
//Yukarida scope yazma sebebimiz beani farkli objelerle olusturmamiza yariyor.Normalde default olarak singeltondur.Singelton olunca bir bean uretir ve her seferinde ayni refesansli bean cagirir.
public class SlackService implements MsgService {

    @PostConstruct
    //obje olusturduktan hemen sonra calisicak method
    public void postConstruct(){
        System.out.println("------> Slack Service objesi olustu");
    }

    @PreDestroy
    //obje silmeden hemen once calisicak method
    public void preDestroy(){
        System.out.println("------> Slack Service objesi imha edildi!!!");
    }

    @Autowired
    private Random rnd;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz slack ile gonderiliyor...." + message);
    }

    @Override
    public void saveMessage(Message message) {
        //Random rnd = new Random(); //newleme yaptim ama burda newleme yapmama aslinda gerek yok
        System.out.println(rnd.nextInt(100));
    }
}
