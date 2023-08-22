package edu.icesi.taskmanagement.controllers;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.services.IProjectService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private IProjectService projectService;


    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public Project findOne(@PathVariable Long id){
        return  new Project(id, "testName", LocalDate.now());
    }

    @PostMapping
    public Project create(@RequestBody Project newProject){
        return this.projectService.save(newProject);
    }



}
