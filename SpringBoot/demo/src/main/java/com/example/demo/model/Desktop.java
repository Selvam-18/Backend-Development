package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

    public void compile() {
        System.out.println("Compiling from Desktop");
    }
}