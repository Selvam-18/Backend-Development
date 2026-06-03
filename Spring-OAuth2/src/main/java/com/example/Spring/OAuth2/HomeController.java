package com.example.Spring.OAuth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String greet() {
        return "Hello World!";
    }
}
