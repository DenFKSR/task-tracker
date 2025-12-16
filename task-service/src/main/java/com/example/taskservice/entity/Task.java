package com.example.taskservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    TaskStatus status;
    Priority priority;
    Long authorId; // ID из authservice
    Long assigneeId; // ID из authservice
    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;
    LocalDateTime dueDate;
    Date estimatedHours;
    @OneToMany
    @JoinColumn(name = "taskComment_id")
    List <TaskComment> comments = new ArrayList<>();
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
