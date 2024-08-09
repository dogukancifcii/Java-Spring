package com.dogukan.repository;

import com.dogukan.domain.Message;

public class DbRepository implements Repository {
    @Override
    public void saveMessage(Message message) {
        System.out.println("Mesaj veri tabanina kaydedildi...");
    }
}
