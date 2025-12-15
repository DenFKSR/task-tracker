package com.example.taskservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/start")
    public String start() {
        return "taskservice";
    }
}
