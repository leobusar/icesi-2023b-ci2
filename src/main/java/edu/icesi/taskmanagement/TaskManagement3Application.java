package edu.icesi.taskmanagement;

import edu.icesi.taskmanagement.persistence.repository.IProjectRepository;
import edu.icesi.taskmanagement.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "edu.icesi.taskmanagement.persistence")
public class TaskManagement3Application {
	private static final Logger LOG = LoggerFactory.getLogger(TaskManagement3Application.class);
	public static void main(String[] args) {

		SpringApplication.run(TaskManagement3Application.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("edu.icesi.taskmanagement.configuration");

		IProjectRepository projectRepository = ctx.getBean("projectRepositoryImpl", IProjectRepository.class);



	}

}
