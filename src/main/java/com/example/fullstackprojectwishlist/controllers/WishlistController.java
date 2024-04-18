package com.example.fullstackprojectwishlist.controllers;

import com.example.fullstackprojectwishlist.models.Wishlist;
import com.example.fullstackprojectwishlist.models.User;
import com.example.fullstackprojectwishlist.services.UserService;
import com.example.fullstackprojectwishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private UserService userService;

    @GetMapping("/new_wishlist")
    public String insert(@RequestParam int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "wishlist/wishlist_add";
    }

    @PostMapping("/insert_wishlist")
    public String addWishlist(@RequestParam int userId, @RequestParam String wishlistName) {
        wishlistService.addWishlist(userId, wishlistName);
        return "redirect:/myWishlists?userId=" + userId;
    }

    @PostMapping("/wishlist/delete")
    public String deleteWishlist(@RequestParam int wishlistId, @RequestParam int userId) {
        wishlistService.deleteWishlist(wishlistId);
        return "redirect:/myWishlists?userId=" + userId;
    }

   @PostMapping("/wishlist/insert_update")
    public String updateWishlistName(@RequestParam int id, @RequestParam int userId, @RequestParam String newName) {
        wishlistService.updateWishlist(id, newName);
        return "redirect:/myWishlists?userId=" + userId;
    }

    @GetMapping("/wishlist/update")
    public String updateWishlistPage(@RequestParam int id, @RequestParam int userId, Model model) {
        Wishlist wishlist = wishlistService.getWishlist(id);
        User user = userService.getUserById(userId);
        model.addAttribute("wishlist", wishlist);
        model.addAttribute("user", user);
        return "wishlist/wishlist_update";
    }

    // User's wishlists
    @GetMapping("/myWishlists")
    public String myWishlists(@RequestParam int userId, Model model) {
        List<Wishlist> wishlists = wishlistService.getWishlistsByUserId(userId);
        User user = userService.getUserById(userId);

        model.addAttribute("user", user);
        model.addAttribute("wishlists", wishlists);
        return "wishlist/my_wishlists";
    }
}
