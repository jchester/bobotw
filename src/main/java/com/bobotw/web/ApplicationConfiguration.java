package com.bobotw.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
public class ApplicationConfiguration {
    @Bean
    @Primary
    @Qualifier("viewResolver")
    public ViewResolver j2htmlViewResolver() {
        return new BeanNameViewResolver();
    }
}

