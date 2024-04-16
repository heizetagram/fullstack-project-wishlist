package com.example.fullstackprojectwishlist.controllers;

import com.example.fullstackprojectwishlist.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.fullstackprojectwishlist.services.UserService;
import org.springframework.ui.Model;
import java.util.List;


@Controller
public class UserController {

    @Autowired
     private UserService userService;

    // User 'front page' #skal nok ændres
    @GetMapping("/user")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "home/user";
    }

    // Create user
    @GetMapping("/newUser")
    public String insert() {
        return "user/user_add";
    }
    @PostMapping("/addUser")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userPassword) {
        userService.addUser(firstName, lastName, email, userPassword);
        return "redirect:/user";
    }


    // Delete user
    @PostMapping("/deleteUser")
    public String deleteUsers(@RequestParam int userId) {
       userService.deleteUserById(userId);
        return "redirect:/user";
    }

    // Update user
    @GetMapping("/prepareUserUpdate")
    public String updateUserPage(@RequestParam int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/user_update";
    }
    @PostMapping("/updateUser")
    public String updateUserName(@RequestParam int userId, @RequestParam String newFirstName, @RequestParam String newLastName) {
        userService.updateUserName(userId, newFirstName, newLastName);
        return "redirect:/user";
    }


}
