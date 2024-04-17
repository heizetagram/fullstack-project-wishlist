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
    @PostMapping("/addUser")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userPassword, Model model) {
        userService.addUser(firstName, lastName, email, userPassword);
        User user = userService.getUserByEmailAndPassword(email, userPassword);
        model.addAttribute("user", user);
        return "user/user_frontpage";
    }


    // Delete user
    @PostMapping("/deleteUser")
    public String deleteUsers(@RequestParam int userId) {
       userService.deleteUserById(userId);
        return "home/index";
    }

    // Update user
    @GetMapping("/prepareUserUpdate")
    public String updateUserPage(@RequestParam int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/user_update";
    }
    @PostMapping("/updateUser")
    public String updateUserName(@RequestParam int userId, @RequestParam String newFirstName, @RequestParam String newLastName, Model model) {
        userService.updateUserName(userId, newFirstName, newLastName);
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/my_user";
    }

    // User login
    @PostMapping("/loginAttempt")
    public String loginAttempt(@RequestParam String email, @RequestParam String userPassword, Model model) {
        boolean loginAttempt = userService.login(email, userPassword);
        if (loginAttempt) {
            User user = userService.getUserByEmailAndPassword(email, userPassword);
            model.addAttribute("user", user);
            return "user/user_frontpage";
        } else {
            return "redirect:/login";
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
