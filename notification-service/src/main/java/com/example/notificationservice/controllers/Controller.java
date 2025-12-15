package com.example.notificationservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/start")
    public String start() {

        return  "notificationservice";
    }
}
