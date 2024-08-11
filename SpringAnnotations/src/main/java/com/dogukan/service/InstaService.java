package com.dogukan.service;

import com.dogukan.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class InstaService implements MsgService {
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz insta ile gonderiliyor..." + message);
    }

    @Override
    public void saveMessage(Message message) {

    }
}
