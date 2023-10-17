package edu.icesi.taskmanagement.services.impl;

import edu.icesi.taskmanagement.persistence.models.Task;
import edu.icesi.taskmanagement.persistence.repositories.ITaskRepository;
import edu.icesi.taskmanagement.services.ITaskService;
import jakarta.persistence.criteria.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Iterable<Task> findAll(int page, int size, String sort, String order) {
        if(sort == null)
            return taskRepository.findAll(PageRequest.of(page, size));
        else
            if(order.equals("desc"))
                return taskRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Order.desc(sort))) );
            else
                return taskRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Order.asc(sort))) );

    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
