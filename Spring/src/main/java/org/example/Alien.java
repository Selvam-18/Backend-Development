package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private int age;

    @Autowired
    @Qualifier("com2")
    private Computer com;

//    public Alien() {
//        System.out.println("Alien called");
//    }

//    public Alien(int age, Laptop com) {
//        this.age = age;
//        this.com = com;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void code() {
        System.out.println("Coding");
        System.out.println(this.getAge());
        com.compile();
    }

}
