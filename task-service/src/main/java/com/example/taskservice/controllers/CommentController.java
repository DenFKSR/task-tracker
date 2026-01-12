package com.example.taskservice.controllers;

import com.example.taskservice.dto.request.TaskCommentRequest;
import com.example.taskservice.dto.response.TaskCommentResponse;
import com.example.taskservice.service.TaskCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final TaskCommentService taskCommentService;

    @PostMapping("/add_comment/{taskId}")
    public TaskCommentResponse addComment(@PathVariable Long taskId, @RequestBody TaskCommentRequest request){
        return  taskCommentService.addComment(taskId,request);
    }
    @GetMapping("/get_comment/{id}")
    public TaskCommentResponse getComment(@PathVariable Long id){
        return taskCommentService.getComment(id);
    }
    @PutMapping("/update_comment/{id}")
    public TaskCommentResponse updateComment(@PathVariable Long id, @RequestBody TaskCommentRequest request){
        return taskCommentService.updateComment(id,request);
    }

    @DeleteMapping("/delete_comment/{id}")
    public void deleteComment(@PathVariable Long id){
       taskCommentService.deleteComment(id);
    }






}
