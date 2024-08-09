package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.DbRepository;

public class WhatsappService implements MsgService {
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz whatsapp uzerinden gonderiliyor... " + message);
    }

    @Override
    public void saveMessage(Message message) {
        DbRepository repository = new DbRepository();
        repository.saveMessage(message);
    }
}
