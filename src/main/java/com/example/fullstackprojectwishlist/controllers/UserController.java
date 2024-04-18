package com.example.fullstackprojectwishlist.controllers;

import com.example.fullstackprojectwishlist.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.fullstackprojectwishlist.services.UserService;
import org.springframework.ui.Model;


@Controller
public class UserController {

    @Autowired
     private UserService userService;

    // Create user
    @GetMapping("/newUser")
    public String insert() {
        return "user/user_add";
    }
    @PostMapping("/createUserAttempt")
    public String createUserAttempt(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userPassword, Model model) {
        boolean createUserAttempt = userService.checkIfEmailIsTaken(email);
        model.addAttribute("invalidMessage", "E-mail findes allerede");
        if (!createUserAttempt) {
            userService.addUser(firstName, lastName, email, userPassword);
            User user = userService.getUserByEmailAndPassword(email, userPassword);
            model.addAttribute("user", user);
            return "user/user_frontpage";
        } else {
            return "user/user_add";
        }
    }

    // Delete user
    @PostMapping("/deleteUser")
    public String deleteUsers(@RequestParam int userId) {
       userService.deleteUserById(userId);
        return "home/index";
    }

    // Update user
    @PostMapping("/updateUserAttempt")
    public String updateUserAttempt(@RequestParam int userId, @RequestParam String newFirstName, @RequestParam String newLastName, @RequestParam String newEmail, @RequestParam String newPassword, Model model) {
        boolean updateUserAttemptByEmail = userService.checkIfEmailIsTaken(newEmail);
        if (!updateUserAttemptByEmail) {
            userService.updateUserWithEmail(userId, newFirstName, newLastName, newEmail, newPassword);
            model.addAttribute("validMessage", "Dine ændringer er blevet gemt");
        } else {
            model.addAttribute("invalidMessage", "E-mail findes allerede");
            userService.updateUserWithoutEmail(userId, newFirstName, newLastName, newPassword);
            model.addAttribute("validMessage", "Dine ændringer er blevet gemt");
        }
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/my_user";
    }

    // User login
    @PostMapping("/loginAttempt")
    public String loginAttempt(@RequestParam String email, @RequestParam String userPassword, Model model) {
        model.addAttribute("invalidMessage", "E-mail eller kodeord er forkert");
        boolean loginAttempt = userService.login(email, userPassword);
        if (loginAttempt) {
            User user = userService.getUserByEmailAndPassword(email, userPassword);
            model.addAttribute("user", user);
            return "user/user_frontpage";
        } else {
            return "home/login";
        }
    }

    // User front page
    @GetMapping("/userFrontpage")
    public String userFrontpage(@RequestParam int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/user_frontpage";
    }

    // My user
    @GetMapping("/myUser")
    public String myUser(@RequestParam int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/my_user";
    }
}
