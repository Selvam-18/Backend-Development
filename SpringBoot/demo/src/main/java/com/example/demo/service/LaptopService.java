package com.example.demo.service;


import com.example.demo.model.Computer;
import com.example.demo.model.Laptop;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    public void doService(Computer l) {
        System.out.println("Laptop Serviced!");
        l.compile();
    }
}
