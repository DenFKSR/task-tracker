package com.example.taskservice.controllers;


import com.example.taskservice.dto.request.ProjectRequest;
import com.example.taskservice.dto.response.ProjectResponse;
import com.example.taskservice.dto.response.TaskResponse;
import com.example.taskservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер д
 */

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
//@NoArgsConstructor
public class ProjectController {


    private final ProjectService projectService;

    @PostMapping("/add_project")
    //  @Operation(summary = "Создание проекта")
    public ProjectResponse addProject(@RequestBody ProjectRequest request) {
        return projectService.addProject(request);
    }


    @GetMapping("/get_project/{id}")
    //@Operation(summary = "Получение информации по проекту")
    public ProjectResponse getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @GetMapping("/get_all_projects")
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/get_project_tasks/{id}")
    public List<TaskResponse> getProjectTasks(@PathVariable Long id) {
        return projectService.getProjectTasks(id);
    }


    @PutMapping("/update_project/{id}")
    //@Operation(summary = "Получение информации по проекту")
    public ProjectResponse updateProject(@PathVariable Long id, @RequestBody ProjectRequest request) {
        return projectService.updateProject(id, request);
    }


    @DeleteMapping("/delete_project/{id}")
    //@Operation(summary = "Получение информации по проекту")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }


}
