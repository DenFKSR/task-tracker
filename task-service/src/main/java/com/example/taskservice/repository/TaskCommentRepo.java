package com.example.taskservice.repository;

import com.example.taskservice.entity.TaskComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskCommentRepo extends JpaRepository<TaskComment, Long> {


}
