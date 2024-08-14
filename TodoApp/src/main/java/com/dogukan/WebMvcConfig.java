package com.dogukan;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration //configurasyon yapacagimizi belirten anatasyon
@EnableWebMvc //spring web mvc aktif etmek icin
@ComponentScan //default olarak bulundugu package tarar


//bu classta webMvc ile ilgili ayarlamalar yapilacak
public class WebMvcConfig implements WebMvcConfigurer {


    // View Resolver
    @Bean //asssagidaki class spring icerisinde oldugu icin Bean kullanildi
    public InternalResourceViewResolver resolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class); // Java kodlari ile JSP
        resolver.setPrefix("/WEB-INF/views/"); // View dosyalarinin lokasyonu
        resolver.setSuffix(".jsp"); // Dosya uzantisi
        //abc --> /WEB-INF/views/abc.jsp

        return resolver;
    }


    //assagidaki yazim ornek olsun diye static path belirtme yapildi
    //static sayfalar iceren requestlerin
    //dispatcher servlet ile karsilanmasina gerek yok.Cunku geri donus almiyor.dinamik sayfalar geri donus aliyor

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").
                setCachePeriod(0);
    }


}
