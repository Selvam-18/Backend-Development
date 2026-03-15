package org.example;

import java.sql.*;


public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost5432/demo";
        String userName = "postgres";
        String password = "Selvam@18";
        Connection con = DriverManager.getConnection(url, userName, password);

        System.out.println("Connection Established!");
    }
}
