package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.DbRepository;
import com.dogukan.repository.Repository;

public class WhatsappService implements MsgService {

    private Repository repository;

    public WhatsappService(Repository repository) {
        this.repository = repository;
    }

    public void sendMessage(Message message) {
        System.out.println("Mesajiniz whatsapp uzerinden gonderiliyor... " + message);
    }

    @Override
    public void saveMessage(Message message) {
        repository.saveMessage(message);
    }
}
