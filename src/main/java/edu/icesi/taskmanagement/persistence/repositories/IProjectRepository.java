package edu.icesi.taskmanagement.persistence.repositories;
import java.util.List;
import  java.util.Optional;
import edu.icesi.taskmanagement.persistence.models.Project;

public interface IProjectRepository {
    Optional<Project> findById(Long id);

    List<Project> getAll();

    Project save(Project project);
}
