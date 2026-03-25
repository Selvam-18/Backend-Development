package org.example.config;

import org.example.Alien;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

//    @Bean
//    public Alien alien(Computer com) {
//        Alien obj = new Alien();
//        obj.setCom(desktop());
//        return obj;
//    }
//
//
//    @Bean
//    @Primary
//    public Desktop desktop() {
//        return new Desktop() ;
//    }
//
//    @Bean
//    public Laptop laptop() {
//        return new Laptop() ;
//    }

}
