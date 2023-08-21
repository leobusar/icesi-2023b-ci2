package edu.icesi.taskmanagement.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Sin  Boot, debemos  agregar las dependencias web
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "edu.icesi.taskmanagement.controllers" })
public class WebConfiguration {

}
