package com.example.fullstackprojectwishlist.controllers;

import com.example.fullstackprojectwishlist.models.Wish;
import com.example.fullstackprojectwishlist.models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.fullstackprojectwishlist.services.WishService;

import java.util.List;

@Controller
public class WishController {
    @Autowired
    private WishService wishService;

    @GetMapping("/wish")
    public String getAllWishes(@RequestParam("wishlistId") int wishlistId, Model model) {
        List<Wish> wishes = wishService.getAllWishesByWishlistId(wishlistId);
        model.addAttribute("wishes", wishes);
        return "home/my_wishlist";
    }

    @GetMapping("/new_wish")
    public String insert() {
        return "wish/wish_add";
    }

    @PostMapping("/addWish")
    public String addWish(@RequestParam int wishlistId, @RequestParam String wishName, @RequestParam String wishDescription, @RequestParam double price) {
        wishService.addWish(wishlistId, wishName, wishDescription, price);
        return "redirect:wish/my_wishlist";
    }

    @GetMapping("/prepare_update")
    public String prepareUpdate(@RequestParam int wishId, Model model) {
        model.addAttribute(wishService.prepareUpdate(wishId));
        return "wish/wish_update";
    }
}
