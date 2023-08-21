package edu.icesi.taskmanagement.controllers;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.services.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "projects")
public class ProjectController {

    private final IProjectService projectService;
    private static final Logger LOG = LoggerFactory.getLogger(ProjectController.class);

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

//    @GetMapping(path = "/1")
//    public Project findOne() {
//        return new Project(1L,"testName", LocalDate.now());
//    }
    @GetMapping( "/{id}")
    public Project findOne(@PathVariable Long id) {
        if (this.projectService.findById(id).isPresent())
            return  this.projectService.findById(id).get();

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @PostMapping("")
    public Project create(@RequestBody Project newProject) {
        LOG.info("Project: ", newProject);
        return this.projectService.save(newProject);

    }
    @PutMapping( "/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project newProject) {
        return this.projectService.save(newProject);
    }
}
