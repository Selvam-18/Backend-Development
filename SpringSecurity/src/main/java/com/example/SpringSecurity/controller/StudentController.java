package com.example.SpringSecurity.controller;


import com.example.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>( List.of(
        new Student(1, "Ezio", "Apple"),
        new Student(2, "Kenway", "Piracy")
    )
    );

    @GetMapping("token")
    public CsrfToken getCSRFToken(HttpServletRequest req) {
        return (CsrfToken) req.getAttribute("_csrf");
    }
    @GetMapping("student")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("student")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Added successfully";
    }
}
