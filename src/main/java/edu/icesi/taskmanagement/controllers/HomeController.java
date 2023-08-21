package edu.icesi.taskmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public  String getHome(){
        return  "home";
    }
}
