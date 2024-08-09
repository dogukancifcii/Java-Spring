package com.dogukan.service;

import com.dogukan.domain.Message;

public class WhatsappService implements MsgService {
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz whatsapp uzerinden gonderiliyor... " + message);
    }
}
