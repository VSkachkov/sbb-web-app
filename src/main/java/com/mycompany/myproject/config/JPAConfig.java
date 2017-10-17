package com.mycompany.myproject.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.embedded.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.core.env.Environment;

import java.sql.SQLException;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.mycompany.myproject.persist")
@ImportResource("classpath*:persistence.xml")
@EnableJpaRepositories("com.mycompany.myproject.persist")
public class JPAConfig {
//
//    @Bean (name = "entityManagerFactory")
//    public EntityManagerFactory getEntityManagerFactory() {
//        return Persistence.createEntityManagerFactory("sbb-persistence-unit");
//    }
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager() {
////        return new JpaTransactionManager();
//        return new JtaTransactionManager();
//    }

    @Autowired
    Environment env;


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("0000");
        ds.setUrl("jdbc:mysql://localhost:3306/SBB_DB");

        Resource initschema = new ClassPathResource("resources/sbb_schema.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initschema);
        DatabasePopulatorUtils.execute(databasePopulator, ds);


        return ds;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[] { "com.mycompany.myproject.persist" });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        return factoryBean;
    }



    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DozerBeanMapper getMapper() {
        return new DozerBeanMapper();
    }

}
