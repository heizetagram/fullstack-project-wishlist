package controllers;

import models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.WishlistService;

import java.util.List;

@Controller
public class WishListController {

    @Autowired
    private WishlistService wishlistService;

    /* UDKOMMENTERET FORDI JEG SKAL PUSH
    @GetMapping("/wishlist")
    public String viewWishlist(Model model) {
        // lav metode i wishlist
        List<Wishlist> wishlists = wishlistService
        wishlistService.getWishlists();
        model.addAttribute("wishlists", wishlists);
        return "wishlist";
    }

     */

    @PostMapping("/wishlist/add")
    public String addWishlist(@RequestParam int userId, @RequestParam String wishlistName) {
        // Lad addwishlist metode
        wishlistService.addWishlist(userId, wishlistName);
        return "redirect:/wishlist";
    }

    @PostMapping("/wishlist/delete")
    public String deleteWishlist(@RequestParam int wishlistId) {
        // lav metode i wishlist
        wishlistService.deleteWishlist(wishlistId);
        return "redirect:/wishlist";
    }
}
