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

    public void addUser(String firstName, String lastName, String email, String userPassword) {
        String query = "INSERT INTO user (first_name, last_name, email, user_password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, userPassword);
    }

    public User getUserById(int userId) {
        String query = "SELECT * FROM user WHERE user_id = ?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, userId);
    }

    public User getUserByEmail(String email) {
        String query = "SELECT * FROM user WHERE email = ?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(query, rowMapper, email);
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public void deleteUserById(int userId) {
        String query = "DELETE FROM user WHERE user_id = ?";
        jdbcTemplate.update(query, userId);
    }

    public void updateUserWithEmail(int userId, String newFirstName, String newLastName, String newEmail, String newPassword) {
        String query = "UPDATE user SET first_name = ?, last_name = ?, email = ?, user_password = ? WHERE user_id = ?";
        jdbcTemplate.update(query, newFirstName, newLastName, newEmail, newPassword, userId);
    }

    public void updateUserWithoutEmail(int userId, String newFirstName, String newLastName, String newPassword) {
        String query = "UPDATE user SET first_name = ?, last_name = ?, user_password = ? WHERE user_id = ?";
        jdbcTemplate.update(query, newFirstName, newLastName, newPassword, userId);
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