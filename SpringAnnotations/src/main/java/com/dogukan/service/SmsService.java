package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.DbRepository;
import com.dogukan.repository.Repository;

public class SmsService implements MsgService {
    private Repository repository; //hangi repo belli degil

    public SmsService(Repository repository){//cons ile repository hangi repoya baglanicak onu seciyoruz
        this.repository=repository;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Sms ile mesaj gonderiliyor.... " + message);
    }

    @Override
    public void saveMessage(Message message) {
        repository.saveMessage(message);
    }
}
