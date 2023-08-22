package edu.icesi.taskmanagement.configuration;

import edu.icesi.taskmanagement.persistence.models.BeanA;
import edu.icesi.taskmanagement.persistence.models.BeanB;
import edu.icesi.taskmanagement.persistence.models.BeanC;
import edu.icesi.taskmanagement.persistence.repository.impl.ProjectRepositoryImpl;
import edu.icesi.taskmanagement.service.impl.ProjectServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
    @Bean
    public ProjectRepositoryImpl projectRepositoryImpl(){
        return  new ProjectRepositoryImpl();
    }

    @Bean
    public  BeanA beanA(){
        return new BeanA();
    }

    @Bean(initMethod = "initialize")
    public BeanB beanB(){
        return new BeanB();
    }

    @Bean(destroyMethod = "destroy")
    public BeanC beanC(){
        return new BeanC();
    }
}
