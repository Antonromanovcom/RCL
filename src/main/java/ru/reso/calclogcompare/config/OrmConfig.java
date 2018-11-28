package ru.reso.calclogcompare.config;

import java.util.Properties;
import javax.sql.DataSource;
import ru.reso.calclogcompare.model.Premium;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring's configuration for beans that are related to ORM and data access.
 *
 * @author ROMAB
 */
@Configuration
@EnableTransactionManagement
public class OrmConfig {


    /**
     * Hibernate's properties.
     */

    /**
     * Диалект. В нашем случае - Оракл.
     */
    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    /**
     * Показывать sql в консоле или нет.
     */
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    /**
     * Дефолтная схема БД.
     */
    @Value("${db.defaultschema}")
    private String defaultSchema;

    /**
     * Мерзкий параметр, который наделал нам делов. Его
     * всегда делать validate, иначе поудаляет к черту
     * все таблицы из БД.
     */
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2dll;


    /**
     * Привязываем Датасарс. В данном случае уже вяжемся
     * через JNDI, то есть через GlassFish Connection Pools.
     *
     * @return the data source
     */
    @Bean
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("OSAGO");
        return dataSource;
    }

    /**
     * Выставляем Hibernate свойства. Все по стандарту.
     *
     * @return the data source
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
     * Создаем фабрику сессий.
     *
     * @param dataSource - датасорс наш.
     * @return - фабрика сессий.
     */
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(final DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(hibernateProperties());
        sessionBuilder.addAnnotatedClasses(Premium.class);
        return sessionBuilder.buildSessionFactory();
    }

    /**
     * Транзакции для Хибернейта.
     *
     * @param sessionFactory - фабрика сессий Хибернейта
     * @return - HibernateTransactionManager.
     */
    @Bean
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
        final HibernateTransactionManager htm =
                new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }

}
