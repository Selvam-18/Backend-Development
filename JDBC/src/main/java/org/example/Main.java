package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/Demo";
        String userName = "postgres";
        String password = "****";
        // CRUD OPERATIONS
        String fetchQuery = "DELETE FROM base WHERE sno = 4";
        String insertQuery = "INSERT INTO base VALUES (?, ?, ?)";

        int sno = 5;
        String email = "test5@gmail.com";
        String name = "Test5";
        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection Established!");

        // Normal Statement

        // Statement st = con.createStatement();

        // PreparedStatement
        PreparedStatement st = con.prepareStatement(insertQuery);

        // Setting values with dynamic values in Prepared Statement
        st.setInt(1, sno);
        st.setString(2, email);
        st.setString(3, name);
        st.execute();


        con.close();
        System.out.println("Connection closed!");
    }
}