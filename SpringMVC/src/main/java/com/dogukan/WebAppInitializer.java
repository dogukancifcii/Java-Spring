package com.dogukan;


//java tabanli web uygulamalari web.xml dosyasi ile configure edilir
//bu class web.xml dosyasi yerine kullanilir

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//AbstractAnnotationConfig...: DispatcherServlet konfigurasyonunu vermek icin gerekli class
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { //dataya erisim : Hibernate,JDBC
        return new Class[]{
                RootConfig.class
        };

    }

    @Override
    protected Class<?>[] getServletConfigClasses() { //viewresolver
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override//hangi url ile gelen istekler servlet tarafindan karsilanicak onun ayarlamasi
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
