package edu.icesi.taskmanagement.services.impl;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.persistence.repositories.IProjectRepository;
import edu.icesi.taskmanagement.services.IProjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectRepository projectRepository;

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
