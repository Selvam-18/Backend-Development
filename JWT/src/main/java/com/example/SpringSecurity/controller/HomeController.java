package com.example.SpringSecurity.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String greet(HttpServletRequest req) {
        return "Hello World" + req.getSession().getId();
    }
}
