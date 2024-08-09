package com.dogukan.controller;

import com.dogukan.domain.Message;
import com.dogukan.repository.FileRepository;
import com.dogukan.repository.Repository;
import com.dogukan.service.MailService;
import com.dogukan.service.MsgService;
import com.dogukan.service.SmsService;
import com.dogukan.service.WhatsappService;

public class MessageApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setBody("Spring is COMING...");
        Repository repository = new FileRepository();
        MsgService service = new MailService(repository);

        //olusturdugumuz mesaji mail ile gondermek istersem!!!
        //MailService mailService = new MailService();//guncellemek icin burayi sildim
        //mailService.sendMessage(message);

        //ayni mesaji mail ile degil whatsapp ile gondermek istersem
        //WhatsappService whatsappService = new WhatsappService(); //burayi tekrar olusturdum
        //whatsappService.sendMessage(message);

        //ayni mesaji whatsapp yerine sms ile gonder deseydim!!!
        //SmsService smsService = new SmsService();
        //smsService.sendMessage(message);

        //------------------------------------------------------
        service.sendMessage(message);//ne ile new'lersem ona gore degisiklik olur!!!

        //bu mesajlari db'ye kaydetmek istiyorum
        //service.saveMessage(message);

        //ben bu mesaji db'e degilde bir dosyanin icerisine(file) kaydetmek istersem
        //service.saveMessage(message);

        //-------------------------------
        service.saveMessage(message);
    }
}
