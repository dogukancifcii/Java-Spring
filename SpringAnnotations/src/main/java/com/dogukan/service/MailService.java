package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.DbRepository;

public class MailService implements MsgService {
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz mail ile gonderiliyor..." + message);

    }

    @Override
    public void saveMessage(Message message) {
        DbRepository dbRepository = new DbRepository();
        dbRepository.saveMessage(message);
    }
}
