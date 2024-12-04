package com.mung.square.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("Configuring resource handler for static files...");
        registry.addResourceHandler("/fullstack7/downloads/**")
                .addResourceLocations("file:C:/fullstack7/downloads/");
    }
}
