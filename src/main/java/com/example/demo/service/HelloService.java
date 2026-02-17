package com.example.demo.service;

import com.example.demo.model.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloResponse getMessage() {
        return new HelloResponse(
                "Hello from Spring Boot",
                "CI/CD Pipeline Working"
        );
    }
}
