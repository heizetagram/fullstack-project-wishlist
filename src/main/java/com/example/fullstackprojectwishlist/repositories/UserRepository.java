package com.example.fullstackprojectwishlist.repositories;

import com.example.fullstackprojectwishlist.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Add user
   /* public void addUser(String firstName, String lastName, String email, String userPassword) {
        String query = "Insert INTO user(first_name, last_name, email, user_password)" +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, userPassword);
    } */
    // Add user
    public void addUser(String firstName, String lastName, String email, String userPassword) {
        String query = "INSERT INTO user (first_name, last_name, email, user_password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, userPassword);
    }


    public User getUserById(int userId) {
        String query = "SELECT * FROM user WHERE user_Id = ?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, userId);
    }

    /*public User getUserById(int userId) {
        String query = "SELECT user_id, first_name, last_name, email, user_password FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
    }*/


    public void updateUserById(int userId, String firstName, String lastName, String email, String userPassword) {
        String query = "UPDATE user " +
                "SET userId = ? " +
                "first_name = ?" +
                "last_name = ?" +
                "email = ?" +
                "user_password = ?" +
                "WHERE userId = ?";
        jdbcTemplate.update(query, userId, firstName, lastName, email, userPassword);
    }

    public List<User> getAllUsers() {
        String query = "SELECT  * FROM user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper(User.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void deleteUserById(int userId) {
        String query = "DELETE FROM user WHERE user_id = ?";
        jdbcTemplate.update(query, userId);
    }

    public void updateUserName(int userId, String newFirstName, String newLastName) {
        String query = "UPDATE user SET first_name = ?, last_name = ? WHERE user_id = ?";
        jdbcTemplate.update(query, newFirstName, newLastName, userId);
    }

    public User getUserByEmailAndPassword(String email, String userPassword) {
        String query = "SELECT * FROM user WHERE email = ? AND user_password = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(query, rowMapper, email, userPassword);
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }
}