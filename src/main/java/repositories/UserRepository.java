package repositories;

import models.User;
import models.Wish;
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
    public void addUser(String firstName, String lastName, String email, String userPassword) {
        String query = "Insert INTO user(String firstName, String lastName, String email, String userPassword)" +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, userPassword);
    }


    public User getUserById(int userId) {
        String query = "SELECT * FROM user WHERE user_Id = ?;";
        return jdbcTemplate.queryForObject(query, User.class, userId);
    }

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

    public List<User> getUsers() {
        String query = "SELECT  * FROM user";
        RowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void deleteUser(int userId) {
        String query = "DELETE FROM user WHERE userId = ?";
        jdbcTemplate.update(query, userId);
    }
}