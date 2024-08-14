package com.dogukan;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Web uygulamamin baslamasi icin ayarlamalar yapilicak.Dispetcher server tomcat ile calisicak.web.xml yerini tutan class.Configurasyon icin ayarlamalari burada yapicaz.!Bu class configurasyon classi degil yonlendirme classi.Spring bize kod bazli yonlendirme yapmamiza yariyor.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //yukaridaki abstract class Dispackt server ayarlari icin var.Method veriyor bize.


    @Override
    protected Class<?>[] getRootConfigClasses() {//db ve hibernate ile config
        return new Class[]{
                RootContextConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//MVC yani Dispatcher servlet ile ilgili ayarlar
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() { //baseURL/...
        // uygulamada hangi requestlerin gelecegini yaziyoruz.
        return new String[]{
                "/"
        };
    }


}
