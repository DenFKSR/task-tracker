package com.example.taskservice.controllers;

import com.example.taskservice.dto.request.TaskRequest;
import com.example.taskservice.dto.response.TaskResponse;
import com.example.taskservice.service.TaskService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
//@NoArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @PostMapping("/add_task/{projectId}")
    public TaskResponse addTask(@PathVariable Long projectId, @RequestBody TaskRequest request) {
        return taskService.addTask(projectId, request);
    }

    @GetMapping("/get_task/{id}")
    public TaskResponse getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PutMapping("/update_task/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/delete_task/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}
