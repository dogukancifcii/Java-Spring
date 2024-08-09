package com.dogukan.controller;

import com.dogukan.domain.Message;
import com.dogukan.service.MailService;

public class MessageApplication {
    public static void main(String[] args) {
        Message message =new Message();
        message.setBody("Spring is COMING...");

        //olusturdugumuz mesaji mail ile gondermek istersem!!!
        MailService mailService = new MailService();
        mailService.sendMessage(message);

        //ayni mesaji mail ile degil whatsapp ile gondermek istersem
    }
}
