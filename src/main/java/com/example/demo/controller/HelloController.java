package com.example.demo.controller;

import com.example.demo.service.HelloService;
import com.example.demo.model.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService service;

    public HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public HelloResponse hello() {
        return service.getMessage();
    }
}
