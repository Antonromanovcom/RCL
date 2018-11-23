package com.antonromanov.springhibernate.config;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;


/**
 *   Класс, заменяющий applicationContext.xml
 *   из папки resources.
 */

@Configuration
@ComponentScan(basePackages = { "com.antonromanov.springhibernate" })
@Import({ OrmConfig.class })
public class AppConfig {


/** Класс, который обеспечивает подпихивание
* свойств из файла database.properties.
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
