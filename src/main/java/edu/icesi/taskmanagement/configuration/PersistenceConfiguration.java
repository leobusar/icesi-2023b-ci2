package edu.icesi.taskmanagement.configuration;

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

}
