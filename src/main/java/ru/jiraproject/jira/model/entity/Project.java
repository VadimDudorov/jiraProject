package ru.jiraproject.jira.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    Long projectId;
    @Column(name = "name_project")
    String nameProject;
    @OneToMany(mappedBy = "project")
    List<Task> tasks;
    @CreationTimestamp
    @Column(name = "timestamp_cr")
    LocalDateTime timestampCr;
    @UpdateTimestamp
    @Column(name = "timestamp_cr")
    LocalDateTime timestampUp;

}
