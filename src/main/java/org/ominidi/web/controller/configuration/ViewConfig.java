package org.ominidi.web.controller.configuration;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ViewConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver(
                new Handlebars(new ClassPathTemplateLoader("/templates", ".html"))
        );
        viewResolver.setOrder(1);
        viewResolver.setCache(false);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}
