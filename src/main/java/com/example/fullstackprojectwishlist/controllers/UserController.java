package com.example.fullstackprojectwishlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.fullstackprojectwishlist.services.UserService;


@Controller
public class UserController {

@Autowired
 private UserService userService;

@PostMapping("/addUser")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String userPassword){
            userService.addUser(firstName, lastName, email, userPassword);
            return "home/index";
    }

  @PostMapping("/user/delete")
    public String deleteWishlist(@RequestParam int wishlistId) {
       userService.deleteUser(wishlistId);
        return "redirect:/wishlist";
    }



}
