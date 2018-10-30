package ru.reso.RCL.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("ru.reso.RCL") //это переименуем в следующем коммите
@EnableWebMvc

/**
 * Файлик Web-конфигурации. Раньше помоему такие вещи писали в Web.xml/ Это все необхоимо, чтобы поднимались jsp.
 * Потом мы эту хрень уберем конечно, когда будет чистый REST
 */
public class appWebConfig extends WebMvcConfigurerAdapter {

  
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/"); // место, где лежат jsp наши
        resolver.setSuffix(".jsp"); // расширение файлов, которые надо открывать.
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** вот с этой строчкой я очень долго долбался. Прописываем, где лежат картинки, иконки и прочая лабуда
         */
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
