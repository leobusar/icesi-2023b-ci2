package edu.icesi.taskmanagement.controllers;

import edu.icesi.taskmanagement.persistence.models.Task;
import edu.icesi.taskmanagement.services.ITaskService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/task")
public class TaskController {
    private ITaskService taskService;


    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public Iterable<Task> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(required=false) String sort, @RequestParam(defaultValue="asc") String order) {
        return this.taskService.findAll(page, size, sort, order);
    }

    @GetMapping("/{id}")
    public Task findOne(@PathVariable Long id){
        if(this.taskService.findById(id).isPresent())
            return  this.taskService.findById(id).get();
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @PostMapping
    public Task create(@RequestBody Task newTask){
        return this.taskService.save(newTask);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task newTask){
        if(this.taskService.findById(id).isPresent())
            return this.taskService.save(newTask);
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

}
