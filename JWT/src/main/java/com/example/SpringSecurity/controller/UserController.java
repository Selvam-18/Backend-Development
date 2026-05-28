package com.example.SpringSecurity.controller;


import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.JWTService;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private JWTService jwtService;


    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("register")
    public User registerUser(@RequestBody User user) {
        return service.registerUser(user);
    }


    @PostMapping("login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()
                ));

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "LOGIN FAILED";
        }
    }
}
