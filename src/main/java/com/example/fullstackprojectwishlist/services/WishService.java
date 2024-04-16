package com.example.fullstackprojectwishlist.services;

import com.example.fullstackprojectwishlist.models.Wish;
import com.example.fullstackprojectwishlist.repositories.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class WishService {
    @Autowired
    WishRepository wishRepository;

    public void addWish(int wishlistId, String wishName, String wishDescription, double price) {
        wishRepository.addWish(wishlistId, wishName, wishDescription, price);
    }

    public Wish prepareUpdate(int wishId) {
        return wishRepository.getWishById(wishId);
    }

    public void deleteWishById(int wishId) {
        wishRepository.deleteWishById(wishId);
    }
    
    public void updateWishById(int wishId, int wishlistId, String wishName, String wishDescription, double price) {
        wishRepository.updateWishById(wishId, wishlistId, wishName, wishDescription, price);
    }

    public List<Wish> getAllWishesByWishlistId(@RequestParam int wishlistId) {
        return wishRepository.getAllWishesByWishlistId(wishlistId);
    }
}
