package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Vivobook");
        l1.setRam(16);
        l1.setLid(1);



        Laptop l2 = new Laptop();
        l2.setBrand("Lenovo");
        l2.setModel("LOQ");
        l2.setRam(12);
        l2.setLid(2);

        Laptop l3 = new Laptop();
        l3.setBrand("Apple");
        l3.setModel("Macbook Air");
        l3.setRam(16);
        l3.setLid(3);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session s = sf.openSession();
//        Transaction trnx = s.beginTransaction();
//
//        s.persist(l1);
//        s.persist(l2);
//        s.persist(l3);
//
//        trnx.commit();

//        Laptop data = s.find(Laptop.class, 1);
//        System.out.println(data);

        Query query = s.createQuery("from Laptop where ram = 12", Laptop.class);
        List<Laptop> laptops = query.getResultList();

        System.out.println(laptops);

        s.close();

        sf.close();

    }
}