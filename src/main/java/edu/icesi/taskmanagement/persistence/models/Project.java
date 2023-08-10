package edu.icesi.taskmanagement.persistence.models;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
@AllArgsConstructor
@Data

public class Project {
    private Long id;
    private String name;
    private LocalDate dateCreated;


    public Project(Project project) {
        this(project.getId(), project.getName(), project.getDateCreated());
    }
}
