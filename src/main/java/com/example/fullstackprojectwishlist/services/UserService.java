package com.example.fullstackprojectwishlist.services;

import com.example.fullstackprojectwishlist.models.User;
import com.example.fullstackprojectwishlist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(String firstName, String lastName, String email, String userPassword) {
        try {
            userRepository.addUser(firstName, lastName, email, userPassword);
        } catch (DuplicateKeyException e) {
        }
    }

    public boolean checkIfEmailIsTaken(String email) {
        User user = userRepository.getUserByEmail(email);
        return user != null;
    }

    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

   public void deleteUserById(int userId) {
        userRepository.deleteUserById(userId);
    }

    public void updateUserWithoutEmail(int userId, String newFirstName, String newLastName, String newPassword) {
        userRepository.updateUserWithoutEmail(userId, newFirstName, newLastName, newPassword);
    }

    public void updateUserWithEmail(int userId, String newFirstname, String newLastName, String newEmail, String newPassword) {
        userRepository.updateUserWithEmail(userId, newFirstname, newLastName, newEmail, newPassword);
    }

    public boolean login(String email, String userPassword) {
        User user = userRepository.getUserByEmailAndPassword(email, userPassword);
        return user != null;
    }

    public User getUserByEmailAndPassword(String email, String userPassword) {
        return userRepository.getUserByEmailAndPassword(email, userPassword);
    }
}
