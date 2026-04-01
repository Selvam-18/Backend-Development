package com.example.SpringJDBC.re;

import com.example.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String query = "insert into Student (rollno, name, mark) values (?, ?, ?)";

        int rows = jdbc.update(query, s.getRollNo(), s.getName(), s.getMark());

        System.out.println(rows + " affected! ");
    }

    public List<Student> findAll() {
        String query = "select * from Student";

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMark(rs.getInt("mark"));

                return s;
            }
        };

        return jdbc.query(query, rowMapper);
    }
}
