package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("insta_service")
public class InstaService implements MsgService {

    @Autowired //eger bagimlilik varsa gerektiğinde otomatik değer atamasının yapılmasını sağlıyor.Bizim yerimize new olusturarak obje olusturmus oldu.
    private Repository repo;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz insta ile gonderiliyor..." + message);
    }

    @Override
    public void saveMessage(Message message) {
        repo.saveMessage(message);
    }
}
