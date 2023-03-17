
package com.cultos.demo.Security;

//esta clase crea las configuraciones de mi web

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        
        //registro para que control en login y errores
        registro.addViewController("/").setViewName("index"); //registro para el index
        registro.addViewController("/login"); //registro para el login
        registro.addViewController("/errores/403").setViewName("/errores/403"); //registro para errores
    }
}
