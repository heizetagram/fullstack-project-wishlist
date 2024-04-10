package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.WishService;

@Controller
public class WishController {
    @Autowired
    private WishService wishService;

    @PostMapping("/addWish")
    public String addWish(@RequestParam int wishlistId, @RequestParam String wishName, @RequestParam String wishDescription, @RequestParam double price) {
        wishService.addWish(wishlistId, wishName, wishDescription, price);
        return "redirect:/";
    }

    @GetMapping("/prepare_update")
    public String prepareUpdate(@RequestParam int wishId, Model model) {
        model.addAttribute(wishService.prepareUpdate(wishId));
        return "home/wish_update";
    }
}
