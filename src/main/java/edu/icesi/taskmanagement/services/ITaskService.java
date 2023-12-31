package edu.icesi.taskmanagement.services;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.persistence.models.Task;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ITaskService {
    Optional<Task> findById(Long id);
    Iterable<Task> findAll(int page,int size,String sort, String order);

    Task save(Task Task);
}
