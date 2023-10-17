package edu.icesi.taskmanagement.persistence.models;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dateCreated;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Set<Task> tasks;
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    protected Project() {}
    public Project(Project project) {
        this(project.getName(), project.getDateCreated());
    }

    public Project(String name, LocalDate dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
    }
}
