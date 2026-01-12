package com.example.taskservice.service.interfaces;


import com.example.taskservice.dto.request.TaskCommentRequest;
import com.example.taskservice.dto.response.TaskCommentResponse;

public interface TaskCommentInterface {

    TaskCommentResponse addComment(Long taskId, TaskCommentRequest request);

    TaskCommentResponse getComment(Long id);

    TaskCommentResponse updateComment(Long id, TaskCommentRequest request);

    void deleteComment(Long id);

}
