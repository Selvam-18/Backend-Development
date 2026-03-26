package com.example.demo;

import com.example.demo.model.Alien;
import com.example.demo.model.Desktop;
import com.example.demo.model.Laptop;
import com.example.demo.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Desktop lap1 = context.getBean(Desktop.class);
		LaptopService lap = context.getBean(LaptopService.class);
		lap.doService(lap1);
	}

}
