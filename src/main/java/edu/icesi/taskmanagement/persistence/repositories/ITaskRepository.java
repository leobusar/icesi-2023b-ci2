package edu.icesi.taskmanagement.persistence.repositories;

import edu.icesi.taskmanagement.persistence.models.Task;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITaskRepository extends PagingAndSortingRepository<Task, Long>,  CrudRepository<Task, Long> {

}
