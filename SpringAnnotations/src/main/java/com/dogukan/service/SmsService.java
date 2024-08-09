package com.dogukan.service;

import com.dogukan.domain.Message;

public class SmsService implements MsgService {

    @Override
    public void sendMessage(Message message) {
        System.out.println("Sms ile mesaj gonderiliyor.... " + message);
    }
}
