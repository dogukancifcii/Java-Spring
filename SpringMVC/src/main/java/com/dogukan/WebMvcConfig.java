package com.dogukan;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.dogukan")
@EnableWebMvc //MVC calistirmak etkinlestirmek icin gerekli anatasyon
public class WebMvcConfig implements WebMvcConfigurer {
    //viewresolver
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); //views dosyasi nerde
        resolver.setSuffix(".jsp"); //views dosyasinin uzantisi ne
        resolver.setViewClass(JstlView.class);
        //JSTL : javaStandartTagLibrary: JSP icinde daha az java kodu yazarak işlem yapmamızı saglar
        return resolver;
    }

    //statik sayfa iceren istek geldigi zaman servlata gonderilmesine gerek yok


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**"). //bu url ile gelen istekleri db baglanmadan sun ya da statik olarak sun
                addResourceLocations("/resources").//static kaynak yeri
                setCachePeriod(0);//cache periyodu icin sure verilir
    }
}
