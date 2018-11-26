package com.antonromanov.springhibernate.config;

import java.util.Properties;
import javax.sql.DataSource;

import com.antonromanov.springhibernate.DAO.PremiumDAO;
import com.antonromanov.springhibernate.DAO.PremiumDAOImpl;
import com.antonromanov.springhibernate.model.Premium;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
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




    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }




    @Bean
    public Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.default_schema", defaultSchema);
        properties.put("hibernate.hbm2ddl.auto", hbm2dll);
        return properties;
    }




   /* @Bean
    @SuppressWarnings("deprecation")
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("com.antonromanov.springhibernate.model")
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }*/


    //@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(hibernateProperties());
        sessionBuilder.addAnnotatedClasses(Premium.class);
        return sessionBuilder.buildSessionFactory();
    }

   /* @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        factoryBean.setHibernateProperties(hibernateProperties());
        factoryBean.setAnnotatedClasses(Premium.class);
        return factoryBean;
    }
*/




    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        final HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }

   /* @Autowired
    @Bean(name = "premiumDao")
    public PremiumDAO getPremiumDao(SessionFactory sessionFactory) {
        return new PremiumDAOImpl(sessionFactory);
    }*/

}
