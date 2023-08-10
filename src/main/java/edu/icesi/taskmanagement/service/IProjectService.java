package edu.icesi.taskmanagement.service;

import edu.icesi.taskmanagement.persistence.models.Project;

import java.util.Optional;

public interface IProjectService {
        Optional<Project> findById(Long id);

        Project save(Project project);
}
