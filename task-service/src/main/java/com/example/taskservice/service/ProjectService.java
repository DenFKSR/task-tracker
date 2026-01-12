package com.example.taskservice.service;

import com.example.taskservice.dto.request.ProjectRequest;
import com.example.taskservice.dto.response.ProjectResponse;
import com.example.taskservice.dto.response.TaskResponse;
import com.example.taskservice.entity.Project;
import com.example.taskservice.exceptions.CustomException;
import com.example.taskservice.repository.ProjectRepo;
import com.example.taskservice.service.interfaces.ProjectInterface;
import com.example.taskservice.service.interfaces.ProjectMapper;
import com.example.taskservice.service.interfaces.TaskMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService implements ProjectInterface {
    private final ProjectRepo projectRepo;
    private final ObjectMapper mapper;


    @Override
    public ProjectResponse addProject(ProjectRequest request) {
        projectRepo.findByName(request.getName()).ifPresent(project -> {
            throw new CustomException("project already created", HttpStatus.CONFLICT);
        });
        Project project = mapper.convertValue(request, Project.class);
        project.setCreatedAt(LocalDateTime.now());
        Project savedProject = projectRepo.save(project);
        return ProjectMapper.INSTANCE.toResponse(savedProject);

    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectResponse> getAllProjects() {
        return projectRepo
                .findAll()
                .stream()
                .map(ProjectMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectResponse getProject(Long id) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("project not found"));
        return ProjectMapper.INSTANCE.toResponse(project);
    }


    @Override
    @Transactional(readOnly = true)
    public List<TaskResponse> getProjectTasks(Long id) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("project not found"));

        return ProjectMapper.INSTANCE.toResponse(project).getTasks();
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Project project = mapper.convertValue(projectRepo.findById(id), Project.class);
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setUpdatedAt(LocalDateTime.now());
        Project savedProject = projectRepo.save(project);
        return ProjectMapper.INSTANCE.toResponse(savedProject);
    }

    @Override
    public ProjectResponse changeStatus(Long id, ProjectRequest request) {
        Project project = mapper.convertValue(projectRepo.findById(id), Project.class);
        project.setStatus(request.getProjectStatus());
        Project savedProject = projectRepo.save(project);
        return ProjectMapper.INSTANCE.toResponse(savedProject);
    }


    @Override
    public ProjectResponse setTask(ProjectRequest request) {
        Project project = mapper.convertValue(projectRepo.findByName(request.getName()), Project.class);
        Project savedProject = projectRepo.save(project);
        return ProjectMapper.INSTANCE.toResponse(savedProject);
    }


    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

}
