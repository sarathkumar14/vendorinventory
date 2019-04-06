package com.hack.vendorinventory.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Autowired
    private Environment environment;

    private static final int CHECKOUT_TIMEOUT = Long.valueOf(TimeUnit.SECONDS.toMillis(20)).intValue();
    private static final int MAX_IDLE = Long.valueOf(3600).intValue();
    private static final int MAX_IDLE_EXCESS = Long.valueOf(900).intValue();

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = null;
        try{
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass((environment.getProperty("jdbc.driverClassName")));
            dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
            dataSource.setUser(environment.getProperty("jdbc.user"));
            dataSource.setPassword(environment.getProperty("jdbc.pass"));
            dataSource.setMinPoolSize(5);
            dataSource.setAcquireIncrement(5);
            dataSource.setMaxPoolSize(50);
            dataSource.setIdleConnectionTestPeriod(300);
            dataSource.setInitialPoolSize(5);
            dataSource.setCheckoutTimeout(CHECKOUT_TIMEOUT);
            dataSource.setMaxIdleTime(MAX_IDLE);
            dataSource.setMaxIdleTimeExcessConnections(MAX_IDLE_EXCESS);
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = null;
        try{
            sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(dataSource());
            sessionFactory.setPackagesToScan(new String[]{environment.getProperty("entitymanager.packagesToScan")});
            sessionFactory.setHibernateProperties(hibernateProperties());
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = null;
        try{
            entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
            entityManagerFactoryBean.setDataSource(dataSource());
            entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
            entityManagerFactoryBean.setPackagesToScan(new String[]{environment.getProperty("entitymanager.packagesToScan")});
            entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return entityManagerFactoryBean;
    }

    private HibernateJpaVendorAdapter vendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties() {
        return new Properties() {{
            setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
            setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
            setProperty("hibernate.globally_quoted_identifiers", environment.getProperty("hibernate.globally_quoted_identifiers"));
            setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
            setProperty("hibernate.max_fetch_depth", environment.getProperty("hibernate.max_fetch_depth"));
            setProperty("hibernate.jdbc.fetch_size", environment.getProperty("hibernate.jdbc.fetch_size"));
            setProperty("hibernate.jdbc.batch_size", environment.getProperty("hibernate.jdbc.batch_size"));
            setProperty("hibernate.jdbc.lob.non_contextual_creation", environment.getProperty("hibernate.jdbc.lob.non_contextual_creation"));
            setProperty("hibernate.temp.use_jdbc_metadata_defaults", environment.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
        }
        };
    }

}
