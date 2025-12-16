package com.example.taskservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String description;
    Long createdBy; // ID пользователя из auth-service
    ProjectStatus status = ProjectStatus.ACTIVE;
    @OneToMany
    @JoinColumn(name = "task_id")
    List <Task> tasks = new ArrayList<>();
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
