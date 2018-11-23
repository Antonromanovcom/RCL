package com.antonromanov.springhibernate.config;

import java.util.Properties;
//import javax.naming.NamingException;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *  Spring's configuration for beans that are related to ORM and data access.
 * @author ROMAB
 */
@Configuration
@EnableTransactionManagement
public class OrmConfig {

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
    private String hbm2dll;


    /**
     *  Привязываем датасорс.
     * @return  Датасорс
     */
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }



    /**
     *  Привязываем датасорс через JNDI.
     * @return  Датасорс
     * @throws NamingException
     *
     */

  /*  @Bean
    public DataSource dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("OSAGO");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        try {
            jndiObjectFactoryBean.afterPropertiesSet();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return (DataSource) jndiObjectFactoryBean.getObject();  //NULL!!!
    }*/



    /**
     *  Привязываем хибернейт и
     *  проставляем ему свойства.
     * @return  Свойства
     *
     */
    @Bean
    public Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.default_schema", defaultSchema);
        properties.put("hibernate.hbm2ddl.auto", hbm2dll);
        return properties;
    }


    /**
     *  Сессионная фабрика.
     * @return  собсна фабрика
     *
     */
    @Bean
    @SuppressWarnings("deprecation")
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("com.antonromanov.springhibernate.model")
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        final HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }


}
