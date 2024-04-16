package com.example.fullstackprojectwishlist.services;

import com.example.fullstackprojectwishlist.models.User;
import com.example.fullstackprojectwishlist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(String firstName, String lastName, String email, String userPassword) {
        userRepository.addUser(firstName, lastName, email, userPassword);
    }

    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    public void updateUserById(int userId, String firstName, String lastName, String email, String userPassword) {
        userRepository.updateUserById(userId, firstName, lastName, email, userPassword);
    }
   public void deleteUserById(int userId) {
        userRepository.deleteUserById(userId);
    }

    public List<User> getAllUsers() {
        return  userRepository.getAllUsers();
    }

    public void updateUserName(int userId, String newFirstName, String newLastName) {
        userRepository.updateUserName(userId, newFirstName, newLastName);
    }

    public boolean login(String email, String userPassword) {
        User user = userRepository.getUserByEmailAndPassword(email, userPassword);
        return user != null;
    }

    public User getUserByEmailAndPassword(String email, String userPassword) {
        return userRepository.getUserByEmailAndPassword(email, userPassword);
    }
}
