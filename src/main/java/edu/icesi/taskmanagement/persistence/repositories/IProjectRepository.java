package edu.icesi.taskmanagement.persistence.repositories;
import  java.util.Optional;
import edu.icesi.taskmanagement.persistence.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectRepository extends CrudRepository <Project, Long> {
    Optional <Project> findByName(String name);
}
