package com.dogukan.service;

import com.dogukan.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
//bu classın objelerini biz degil spring olusturacak(biz new ile olusturuyor idik paramiz yetmiyor) ve yoneticek ve objere Spring Bean denir
public class SlackService implements MsgService {

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
