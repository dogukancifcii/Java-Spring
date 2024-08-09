package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.DbRepository;

public class SmsService implements MsgService {

    @Override
    public void sendMessage(Message message) {
        System.out.println("Sms ile mesaj gonderiliyor.... " + message);
    }

    @Override
    public void saveMessage(Message message) {
        DbRepository repository = new DbRepository();
        repository.saveMessage(message);
    }
}
