package edu.icesi.taskmanagement.controllers;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.services.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.ui.Model;
import java.time.LocalDate;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
        projectService.save(new Project(1L,"My Project", LocalDate.now()));
        projectService.save(new Project(2L,"My Project 2", LocalDate.now()));
        projectService.save(new Project(3L,"My Project 3", LocalDate.now()));

    }

    @GetMapping("/{id}")
    public String findOne(Model model, @PathVariable Long id){
        if(this.projectService.findById(id).isPresent()) {
            Project project = this.projectService.findById(id).get();
            model.addAttribute(project);
            return "projects/detail";
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
    @GetMapping("/new")
    public String getForm(){
        return "projects/new";
    }
    @PostMapping
    public Project create(@ModelAttribute Project newProject){
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
