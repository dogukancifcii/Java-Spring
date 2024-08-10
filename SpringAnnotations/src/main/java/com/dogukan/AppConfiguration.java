package com.dogukan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //bu class'in bir konfigurasyon classi oldugunu belirtiyoruz
@ComponentScan("com.dogukan") //bu pathdeki tum companentleri tarar
//default path:AppConfiguration classinin icinde bulundugu path'i tarar
public class AppConfiguration {
}
