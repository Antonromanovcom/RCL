package com.antonromanov.springhibernate.config;

import com.antonromanov.springhibernate.model.Premium;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Класс, заменяющий applicationContext.xml
 * из папки resources.
 */

@Configuration
@ComponentScan(basePackages = {"com.antonromanov.springhibernate"})
@Import({OrmConfig.class})
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig {

/*
    // properties of data source
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    // Hibernate's properties
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${db.defaultschema}")
    private String defaultSchema;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2dll;*/

    /**
     * Класс, который обеспечивает
     * отображение и роутинг
     * jsp файлов.
     *
     * @return - ВьеверРезолвер для отображения jsp
     */
//    @Bean(name = "viewResolver")
//    public InternalResourceViewResolver getViewResolver() {
//        InternalResourceViewResolver viewResolver =
//                new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }


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

    /**
     *  Привязываем датасорс.
     * @return  Датасорс
     *//*
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@oraserv2.reso.ru:1526:osago");
        dataSource.setUsername("webauto");
        dataSource.setPassword("apiwebauto");
        return dataSource;
    }*/


    /*@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }*/


   /* *//**
     *  Привязываем хибернейт и
     *  проставляем ему свойства.
     * @return  Свойства
     *
     *//*
    @Bean
    public Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.default_schema", defaultSchema);
        properties.put("hibernate.hbm2ddl.auto", hbm2dll);
        return properties;
    }
*/

    /**
     *  Сессионная фабрика.
     * @return  собсна фабрика
     *
     */
    /*@Bean
    @SuppressWarnings("deprecation")
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("com.antonromanov.springhibernate.model")
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }*/


    /*@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(hibernateProperties());
        sessionBuilder.addAnnotatedClasses(Premium.class);
        return sessionBuilder.buildSessionFactory();
    }*/

   /* @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        factoryBean.setHibernateProperties(hibernateProperties());
        factoryBean.setAnnotatedClasses(Premium.class);
        return factoryBean;
    }





    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        final HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }*/

    /*@Autowired
    @Bean(name = "premiumDao")
    public PremiumDAO getPremiumDao(SessionFactory sessionFactory) {
        return new PremiumDAOImpl(sessionFactory);
    }*/


}
