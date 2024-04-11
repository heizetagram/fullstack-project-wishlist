package services;

import models.User;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

@Service
public class UserService {
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
   public void deleteUser(int userId){
      userRepository.deleteUser(userId);
    }

}
