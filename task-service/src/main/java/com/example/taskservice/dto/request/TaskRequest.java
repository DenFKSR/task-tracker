package com.example.taskservice.dto.request;

import com.example.taskservice.entity.Priority;
import com.example.taskservice.entity.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskRequest {

    String title;
    String description;
    TaskStatus status;
    Priority priority;
    //authorId; // ID из auth-service
//assigneeId; // ID из auth-service
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime dueDate;

    //Double estimatedHours;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime createdAt;
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime updatedAt;


}
