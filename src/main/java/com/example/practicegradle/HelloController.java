package com.example.practicegradle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        // Java 21 환경에서 정상 동작 확인
        return "Hello Java 21 & Spring Boot 4.0.3 with Gradle!";
    }
}
