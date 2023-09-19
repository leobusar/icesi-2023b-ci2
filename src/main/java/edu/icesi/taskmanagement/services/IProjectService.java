package edu.icesi.taskmanagement.services;

import edu.icesi.taskmanagement.persistence.models.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
        Optional<Project> findById(Long id);

        List<Project> getAll();
        Project save(Project project);
}
