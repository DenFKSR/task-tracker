package com.example.taskservice.service;

import com.example.taskservice.dto.request.TaskRequest;
import com.example.taskservice.dto.response.TaskResponse;
import com.example.taskservice.entity.Project;
import com.example.taskservice.entity.Task;
import com.example.taskservice.entity.TaskStatus;
import com.example.taskservice.exceptions.CustomException;
import com.example.taskservice.repository.ProjectRepo;
import com.example.taskservice.repository.TaskRepo;
import com.example.taskservice.service.interfaces.TaskInterface;
import com.example.taskservice.service.interfaces.TaskMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService implements TaskInterface {
    private final ObjectMapper mapper;
    private final TaskRepo taskRepo;
    private final ProjectRepo projectRepo;

    @Override
    public TaskResponse addTask(Long projectId,TaskRequest request) {
        taskRepo.findTaskByTitle(request.getTitle())
                .ifPresent(task -> {
                    throw new CustomException("task already created", HttpStatus.CONFLICT);
                });
        Task task = mapper.convertValue(request, Task.class);
        task.setStatus(TaskStatus.TODO);
        task.setCreatedAt(LocalDateTime.now());
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("project not found"));
        task.setProject(project);
        Task savedTask = taskRepo.save(task);
        return TaskMapper.INSTANCE.toResponse(savedTask);
    }

    @Override
    public TaskResponse getTask(Long id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        return TaskMapper.INSTANCE.toResponse(task);

    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setDueDate(request.getDueDate());
        //task.setEstimatedHours(request.getEstimatedHours());
        task.setUpdatedAt(LocalDateTime.now());
        Task savedTask = taskRepo.save(task);
        return  TaskMapper.INSTANCE.toResponse(savedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
