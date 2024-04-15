package com.example.fullstackprojectwishlist.controllers;

import com.example.fullstackprojectwishlist.models.Wishlist;
import com.example.fullstackprojectwishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class WishListController {

    @Autowired
    private WishlistService wishlistService;


    @GetMapping("/wishlist")
    public String getAllWishlists(Model model) {
        List<Wishlist> wishlists = wishlistService.getAllWishlists();
        model.addAttribute("wishlists", wishlists);
        return "home/wishlist";
    }

    @GetMapping("/new_wishlist")
    public String insert() {
        return "home/wishlist_add";
    }

    @PostMapping("/insert_wishlist")
    public String addWishlist(@RequestParam int userId, @RequestParam String wishlistName) {
        wishlistService.addWishlist(userId, wishlistName);
        return "redirect:/wishlist";
    }

    @PostMapping("/wishlist/delete")
    public String deleteWishlist(@RequestParam int wishlistId) {
        wishlistService.deleteWishlist(wishlistId);
        return "redirect:/wishlist";
    }

   @PostMapping("/wishlist/insert_update")
    public String updateWishlistName(@RequestParam int id, @RequestParam String newName) {
        wishlistService.updateWishlist(id, newName);
        return "redirect:/wishlist";
    }

    @GetMapping("/wishlist/update")
    public String updateWishlistPage(@RequestParam int id, Model model) {
        Wishlist wishlist = wishlistService.getWishlist(id);
        model.addAttribute("wishlist", wishlist);
        return "home/update_wishlist";
    }
}
