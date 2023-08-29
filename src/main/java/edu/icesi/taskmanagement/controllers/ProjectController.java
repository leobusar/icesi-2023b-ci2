package edu.icesi.taskmanagement.controllers;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.services.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        if(this.projectService.findById(id).isPresent())
            return  this.projectService.findById(id).get();
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @PostMapping
    public Project create(@RequestBody Project newProject){
        return this.projectService.save(newProject);
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project newProject){
        if(this.projectService.findById(id).isPresent())
            return this.projectService.save(newProject);
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }


}
