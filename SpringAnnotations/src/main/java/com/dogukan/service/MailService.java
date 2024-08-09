package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.Repository;

public class MailService implements MsgService {
    Repository repository;


    public MailService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız mail ile gonderiliyor.... : " + message);
    }

    @Override
    public void saveMessage(Message message) {
        //FileRepository respository=new FileRepository();
        repository.saveMessage(message);
    }
}
