package com.example.taskservice.service;

import com.example.taskservice.dto.request.TaskCommentRequest;
import com.example.taskservice.dto.response.TaskCommentResponse;
import com.example.taskservice.entity.Task;
import com.example.taskservice.entity.TaskComment;
import com.example.taskservice.repository.TaskCommentRepo;
import com.example.taskservice.repository.TaskRepo;
import com.example.taskservice.service.interfaces.TaskCommentInterface;
import com.example.taskservice.service.interfaces.TaskCommentMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskCommentService implements TaskCommentInterface {
    private final TaskCommentRepo taskCommentRepo;
    private final ObjectMapper mapper;
    private final TaskRepo taskRepo;


    @Override
    public TaskCommentResponse addComment(Long taskId, TaskCommentRequest request) {
        TaskComment taskComment = mapper.convertValue(request, TaskComment.class);
        taskComment.setCreatedAt(LocalDateTime.now());
        Task task = mapper.convertValue(taskRepo.findById(taskId), Task.class);
        taskComment.setTask(task);
        TaskComment savedTaskComment = taskCommentRepo.save(taskComment);
        return TaskCommentMapper.INSTANCE.toResponse(savedTaskComment);
    }

    @Override
    public TaskCommentResponse getComment(Long id) {
        TaskComment taskComment = taskCommentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("комментарий не найден"));
        return TaskCommentMapper.INSTANCE.toResponse(taskComment);
    }

    @Override
    public TaskCommentResponse updateComment(Long id, TaskCommentRequest request) {
        TaskComment taskComment = taskCommentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("комментарий не найден"));
        taskComment.setContent(request.getContent());
        TaskComment savedTaskComment = taskCommentRepo.save(taskComment);
        return TaskCommentMapper.INSTANCE.toResponse(savedTaskComment);
    }

    @Override
    public void deleteComment(Long id) {
        taskCommentRepo.deleteById(id);
    }
}
