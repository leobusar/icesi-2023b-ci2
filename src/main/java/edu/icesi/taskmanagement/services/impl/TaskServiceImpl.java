package edu.icesi.taskmanagement.services.impl;

import edu.icesi.taskmanagement.persistence.models.Task;
import edu.icesi.taskmanagement.persistence.repositories.ITaskRepository;
import edu.icesi.taskmanagement.services.ITaskService;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class TaskServiceImpl implements ITaskService {
    private ITaskRepository taskRepository;

    public TaskServiceImpl (ITaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
