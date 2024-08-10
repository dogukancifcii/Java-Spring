package com.dogukan.service;

import com.dogukan.domain.Message;
import org.springframework.stereotype.Component;

@Component
//bu classın objelerini biz degil spring olusturacak(biz new ile olusturuyor idik paramiz yetmiyor) ve yoneticek ve objere Spring Bean denir
public class SlackService implements MsgService {


    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz slack ile gonderiliyor...." + message);
    }

    @Override
    public void saveMessage(Message message) {

    }
}
