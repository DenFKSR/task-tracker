package com.example.taskservice.dto.request;

import com.example.taskservice.entity.ProjectStatus;
import com.example.taskservice.entity.Task;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectRequest {

    String name;
    String description;
    ProjectStatus projectStatus;
    Task task;

}
