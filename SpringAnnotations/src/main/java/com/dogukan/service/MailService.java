package com.dogukan.service;

import com.dogukan.domain.Message;

public class MailService implements MsgService {
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz mail ile gonderiliyor..." + message);

    }
}
