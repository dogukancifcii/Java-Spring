package com.dogukan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration //bu class'in bir konfigurasyon classi oldugunu belirtiyoruz
@ComponentScan("com.dogukan") //bu pathdeki tum companentleri tarar
//default path:AppConfiguration classinin icinde bulundugu path'i tarar
@PropertySource("classpath:application.properties")
//application.properties isimli dosyanin bilgilerini okur.Bu bilgileri okuyabilmesi icin dosya yolunu yazmamiz gerekiyor.
public class AppConfiguration {

    //Spring tarafindan olusturulan bir interface bu interface PropertySource aradigmiz dosyalarin okunmasini saglayan metodlari icerir.
    @Autowired
    private Environment environment;

    @Bean //Bean=kucuk java objeleri
    public Random random() {
        return new Random(); //tek bir new keywordu ile istedigim kadar obje olusturabilirim!!!
    }

    //@Value anatasyonu ile yaptigimiz islemleri enveriment ve properties isimli classlar ile yapalim

    //assagida Properties yapisi vardir.Bu yapi key value mantigi ile calisir. Sol tarafa Service kismina cagirilacak isim sag tarafa ise environmet methodu ile application.properties icindeki degisken ismi yazilir.
    @Bean
    public Properties properties() {

        Properties properties = new Properties();
        properties.put("mymail", environment.getProperty("email"));
        properties.put("myphone", environment.getProperty("phone"));
        return properties;
    }
}
