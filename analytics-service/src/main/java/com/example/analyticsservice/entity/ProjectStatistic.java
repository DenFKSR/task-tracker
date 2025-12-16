package com.example.analyticsservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "projectStatistic")
public class ProjectStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long projectId;
    Date statDate;
    Integer totalTasks = 0;
    Integer completedTasks = 0;
    Double completionPercentage = 0.0;
    Double avgTaskCompletionTimeDays = 0.0;
    Double teamProductivityScore = 0.0;
}
