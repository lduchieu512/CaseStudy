package com.codegym.casestudy_spring_module_4.config;

import com.codegym.casestudy_spring_module_4.formatter.DateFomatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigFomatter implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFomatter());
//        registry.addConverter(new DateConverter());
    }
}
