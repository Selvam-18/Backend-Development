package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {
    @Id
    private int ano;
    private String aname;
    private String atech;
    @OneToMany
    private List<Laptop> laptops;

    @Override
    public String toString() {
        return "Alien{" +
                "ano=" + ano +
                ", aname='" + aname + '\'' +
                ", atech='" + atech + '\'' +
                ", laptops=" + laptops +
                '}';
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAtech() {
        return atech;
    }

    public void setAtech(String atech) {
        this.atech = atech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
