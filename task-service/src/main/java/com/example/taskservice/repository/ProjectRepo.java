package com.example.taskservice.repository;

import com.example.taskservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository <Project, Long> {
    Optional<Project> findByName(String name);


    Optional<Project> deleteByName(String name);
}
