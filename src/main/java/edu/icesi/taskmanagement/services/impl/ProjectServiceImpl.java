package edu.icesi.taskmanagement.services.impl;

import edu.icesi.taskmanagement.persistence.models.BeanA;
import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.persistence.repositories.IProjectRepository;
import edu.icesi.taskmanagement.services.IProjectService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {
    private static Logger log = LoggerFactory.getLogger(BeanA.class);

    @Autowired
    private IProjectRepository projectRepository;

//    public ProjectServiceImpl(IProjectRepository projectRepository) {
//        this.projectRepository = projectRepository;
//    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> getAll(){return projectRepository.getAll();}
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Autowired
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostConstruct
    public void post(){
        log.info("Método postconstruct llamado service");
    }
}
