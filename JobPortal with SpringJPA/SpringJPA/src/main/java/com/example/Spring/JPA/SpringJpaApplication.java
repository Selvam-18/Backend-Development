package com.example.Spring.JPA;

import com.example.Spring.JPA.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);

		s1.setRollno(101);
		s1.setName("Paul Atredies");
		s1.setMark(85);

		s2.setRollno(102);
		s2.setName("Chani");
		s2.setMark(85);

//		repo.save(s1);
//		repo.save(s2);
		System.out.println(repo.findByName("Chani"));
		System.out.println(repo.findByMarkGreaterThan(80));

		repo.delete(s2);
	}

}
