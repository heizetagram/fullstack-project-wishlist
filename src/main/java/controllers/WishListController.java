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


    @GetMapping("/wishlist")
    public String getAllWishlists(Model model) {
        List<Wishlist> wishlists = wishlistService.getAllWishlists();
        model.addAttribute("wishlists", wishlists);
        return "wishlist";
    }


    @PostMapping("/wishlist/add")
    public String addWishlist(@RequestParam int userId, @RequestParam String wishlistName) {
        wishlistService.addWishlist(userId, wishlistName);
        return "redirect:/wishlist";
    }

    @PostMapping("/wishlist/delete")
    public String deleteWishlist(@RequestParam int wishlistId) {
        wishlistService.deleteWishlist(wishlistId);
        return "redirect:/wishlist";
    }
}
