package com.example.analyticsservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name= "userStatistic")
public class UserStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Date statDate;
    Integer tasksCreated = 0;
    Integer tasksCompleted = 0;
    Integer tasksInProgress = 0;
    Integer totalTimeSpentMinutes = 0;
    Double avgCompletionTimeHours = 0.0;
    Double onTimeCompletionRate = 0.0;
}
