package com.example.taskservice.service.interfaces;

import com.example.taskservice.dto.request.TaskRequest;
import com.example.taskservice.dto.response.TaskResponse;

public interface TaskInterface {

    TaskResponse addTask(Long projectId,TaskRequest request);

    TaskResponse getTask(Long id);

    TaskResponse updateTask(Long id, TaskRequest request);

    void deleteTask(Long id);


}
