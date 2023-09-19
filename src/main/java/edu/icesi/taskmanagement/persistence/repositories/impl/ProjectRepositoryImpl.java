package edu.icesi.taskmanagement.persistence.repositories.impl;

import edu.icesi.taskmanagement.persistence.models.Project;
import edu.icesi.taskmanagement.persistence.repositories.IProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {
    List <Project> projects = new ArrayList<>();

    public ProjectRepositoryImpl() {
        super();
    }

//    @PostConstruct
//    public void setup() {
//        Project project = new Project(1L, "Spring Course", LocalDate.now());
//        projects.add(project);
//    }

    @Override
    public Optional<Project> findById(Long id){
     return projects.stream().filter(p->p.getId() == id).findFirst();
    }


    public List<Project> getAll(){
        return projects;
    }
    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null){
            projects.add(project);
        }else{
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }


}
