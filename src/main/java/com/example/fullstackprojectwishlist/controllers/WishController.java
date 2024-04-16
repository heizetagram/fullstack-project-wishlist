package com.example.fullstackprojectwishlist.controllers;

import com.example.fullstackprojectwishlist.models.Wish;
import com.example.fullstackprojectwishlist.models.Wishlist;
import com.example.fullstackprojectwishlist.services.WishlistService;
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

    @Autowired
    private WishlistService wishlistService;

    // Wish 'front page'
    @GetMapping("/wish")
    public String getAllWishes(@RequestParam int wishlistId, Model model) {
        List<Wish> wishes = wishService.getAllWishesByWishlistId(wishlistId);
        Wishlist wishlist = wishlistService.getWishlist(wishlistId);

        model.addAttribute("wishlist", wishlist);
        model.addAttribute("wishes", wishes);
        return "home/my_wishlist";
    }

    // Create wish
    @GetMapping("/newWish")
    public String insert(@RequestParam int wishlistId, Model model) {
        Wishlist wishlist = wishlistService.getWishlist(wishlistId);
        model.addAttribute("wishlist", wishlist);
        return "wish/wish_add";
    }
    @PostMapping("/addWish")
    public String addWish(@RequestParam int wishlistId, @RequestParam String wishName, @RequestParam String wishDescription, @RequestParam double price, Model model) {
        wishService.addWish(wishlistId, wishName, wishDescription, price);
        getAllWishes(wishlistId, model);
        return "home/my_wishlist";
    }

    // Delete wish
    @PostMapping("/deleteWish")
    public String deleteWish(@RequestParam int wishId) {
        int wishlistId = wishlistService.getWishlistIdByWishId(wishId);
        wishService.deleteWishById(wishId);
        return "redirect:/wish?wishlistId=" + wishlistId;
    }

    // Update wish
    @GetMapping("/prepareWishUpdate")
    public String prepareUpdate(@RequestParam int wishId, Model model) {
        model.addAttribute("wish", wishService.prepareUpdate(wishId));
        return "wish/wish_update";
    }
    @PostMapping("/updateWish")
    public String updateWish(@RequestParam int wishId, @RequestParam int wishlistId, @RequestParam String wishName, @RequestParam String wishDescription, @RequestParam double price) {
        wishService.updateWishById(wishId, wishlistId, wishName, wishDescription, price);
        return "redirect:/wish?wishlistId=" + wishlistId;
    }
}
