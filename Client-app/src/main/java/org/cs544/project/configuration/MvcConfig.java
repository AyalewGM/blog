package org.cs544.project.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/posts").setViewName("posts");
        registry.addViewController("/").setViewName("posts");
        registry.addViewController("/aboutUs").setViewName("aboutUs");
        registry.addViewController("/login").setViewName("login");
    }

}


