package edu.icesi.taskmanagement.controllers;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.services.IProjectService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

//    @GetMapping(path = "/1")
//    public Project findOne() {
//        return new Project(1L,"testName", LocalDate.now());
//    }
    @GetMapping(value = "/{id}")
    public Project findOne(@PathVariable Long id) {
        return this.projectService.findById(id).get();
    }

    @PostMapping
    public void create(@RequestBody Project newProject) {
        this.projectService.save(newProject);
    }

}
