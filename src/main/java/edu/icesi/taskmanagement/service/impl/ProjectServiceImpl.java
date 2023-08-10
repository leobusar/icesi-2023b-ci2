package edu.icesi.taskmanagement.service.impl;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.persistence.repository.IProjectRepository;
import edu.icesi.taskmanagement.service.IProjectService;

import java.util.Optional;

public class ProjectServiceImpl implements IProjectService {
    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
