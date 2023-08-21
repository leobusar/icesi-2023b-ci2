package edu.icesi.taskmanagement.persistence.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Project {
    private Long id;
    private String name;
    private LocalDate dateCreated;


    public Project(Project project) {
        this(project.getId(), project.getName(), project.getDateCreated());
    }

}
