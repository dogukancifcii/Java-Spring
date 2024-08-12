package com.dogukan.service;

import com.dogukan.domain.Message;
import com.dogukan.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
field injection-->ilk olustururken InstaService icinden olustururuz.Sonradan degistiremeyiz

setter injection --> Sonradan degistirebiliriz. Fakat guvenli degildir.

constructor injection--> sonradan degistiremeyiz fakat ilk olustururken obje olusturarak olustururuz.



*/
@Component("insta_service")
public class InstaService implements MsgService {

    @PostConstruct
    //obje olusturduktan hemen sonra calisicak method
    public void postConstruct(){
        System.out.println("------> Insta Service objesi olustu");
    }

    @PreDestroy
    //obje silmeden hemen once calisicak method
    public void preDestroy(){
        System.out.println("------> Insta Service objesi imha edildi!!!");
    }

    //field injection

    //@Autowired //eger bagimlilik varsa gerektiğinde otomatik değer atamasının yapılmasını sağlıyor.Bizim yerimize new olusturarak obje olusturmus oldu.
    //@Qualifier("fileRepository") //buradan fileRepositorye kaydet demis olduk.
    //birden fazla
    //private Repository repo;

    //field injection'da enjecte etme islemini instaservice classında yapıyorum ve obje olusurken benim enjecte ettiğim değerin değişme olasılığı yok!!!instaservice Class içine gelip tekrardan değiştirebilirim

    //-------------------------------------------------------------------


    //setter injection


    //private Repository repo;
    //@Autowired
    //@Qualifier("fileRepository")
    //public void setRepo(Repository repo) {
    //    this.repo = repo;
    //}

    //sonradan repo degistirebilmeyi sagliyor!!!
    //fakat guvenilir degil

    //-------------------------------------------------------------------

    //constructor injection

    private Repository repo;

    @Autowired //bagimlilik injection olustmasini saglar

    public InstaService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }
    //obje olustururken istedigim repoyu girebilirim.Sonradan degistirme imkanim yok.
    //repo final olur neden cunku sonradan degistirilemez.
    //eger obje olusturarak biz belirlemezsek yukarida olusturdugumuz deger default olarak atanir.

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz insta ile gonderiliyor..." + message);
    }

    @Override
    public void saveMessage(Message message) {
        repo.saveMessage(message);
    }
}
