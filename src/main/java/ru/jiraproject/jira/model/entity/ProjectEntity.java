package ru.jiraproject.jira.model.entity;


import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "projects", schema = "jira")
public class ProjectEntity {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    Long projectId;
    @Column(name = "name_project")
    String name;
    @OneToMany(mappedBy = "project")
    List<TaskEntity> tasks;
    @CreationTimestamp
    @Column(name = "timestamp_cr")
    LocalDateTime timestampCr;
    @UpdateTimestamp
    @Column(name = "timestamp_up")
    LocalDateTime timestampUp;
}
