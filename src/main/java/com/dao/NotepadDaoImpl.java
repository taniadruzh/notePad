package com.dao;

import com.config.ConnectConfig;
import com.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotepadDaoImpl implements NotepadDao {

    private List<Person> notepadList;

    @Autowired
    private Connection connection;

    @Override
    public List<Person> notepadList() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        notepadList = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT * FROM notepad");
            rs = ps.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setName(rs.getString(1));
                person.setSurname(rs.getString(2));
                person.setPhone(rs.getString(3));
                notepadList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return notepadList;
    }


    @Override
    public void add(Person person) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO notepad (name, surname, phone) VALUES (?,?,?);");
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getPhone());
            ps.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Person person) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM notepad WHERE name=? AND surname=? AND phone=?");
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getPhone());
            ps.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
