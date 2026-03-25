package org.example;

import org.springframework.stereotype.Component;

@Component("com2")
public class Laptop implements Computer {

    @Override
    public void compile() {
        System.out.println("Compiling using Laptop");
    }




}
