package com.nutouchh.EventAgency.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/admin/login").setViewName("login");
//        registry.addViewController("/admin/logout").setViewName("logout");
//        registry.addViewController("/").setViewName("index");
        registry.addViewController("/callback/success").setViewName("callback-success");
        registry.addViewController("/callback").setViewName("callback");
//        registry.addViewController("/order/complete").setViewName("complete");
    }
}