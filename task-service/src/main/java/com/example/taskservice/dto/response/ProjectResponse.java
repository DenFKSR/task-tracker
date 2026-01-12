package com.example.taskservice.dto.response;

import com.example.taskservice.entity.ProjectStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectResponse {

    Long id;
    String name;
    String description;
    Long createdBy;
    ProjectStatus status;
    List<TaskResponse> tasks;

}
