package ru.reso.calclogcompare.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;



/**
 * Класс, заменяющий applicationContext.xml
 * из папки resources.
 */
@Configuration
@ComponentScan(basePackages = {"ru.reso.calclogcompare"})
@Import({OrmConfig.class})
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig {



    /**
     * Класс, который обеспечивает
     * отображение и роутинг
     * jsp файлов.
     *
     * @return - ВьеверРезолвер для отображения jsp
     */
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**
     * Класс, который обеспечивает
     * подпихивание свойств
     * из файла database.properties.
     *
     * @return - Какой-то объект свойств
     */
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("database.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }

}
