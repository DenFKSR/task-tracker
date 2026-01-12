package com.example.taskservice.service.interfaces;

import com.example.taskservice.dto.request.ProjectRequest;
import com.example.taskservice.dto.response.ProjectResponse;
import com.example.taskservice.dto.response.TaskResponse;
import com.example.taskservice.entity.Task;

import java.util.List;

public interface ProjectInterface {

    ProjectResponse addProject(ProjectRequest request);

    List<ProjectResponse>getAllProjects();

    ProjectResponse getProject(Long id);

    List<TaskResponse> getProjectTasks(Long id);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    ProjectResponse changeStatus(Long id, ProjectRequest request);

    ProjectResponse setTask(ProjectRequest request);

    void deleteProject(Long id);



}
