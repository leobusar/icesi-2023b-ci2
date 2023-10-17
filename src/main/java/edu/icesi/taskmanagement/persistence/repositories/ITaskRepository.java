package edu.icesi.taskmanagement.persistence.repositories;

import edu.icesi.taskmanagement.persistence.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long> {

}
