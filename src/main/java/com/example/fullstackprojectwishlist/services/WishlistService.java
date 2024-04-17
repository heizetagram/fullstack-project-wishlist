package com.example.fullstackprojectwishlist.services;

import com.example.fullstackprojectwishlist.repositories.WishlistRepository;
import com.example.fullstackprojectwishlist.models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public void addWishlist(int userId, String wishlistName) {
        wishlistRepository.addWishlist(userId, wishlistName);
    }

    public void deleteWishlist(int wishlistId){
        wishlistRepository.deleteWishlist(wishlistId);
    }

    public List<Wishlist> getAllWishlists(){
        return wishlistRepository.getAllWishlists();
    }

    public Wishlist getWishlist(int wishlistID){
        return wishlistRepository.getWishlist(wishlistID);
    }

    public void updateWishlist(int id, String newName) {
        wishlistRepository.updateWishlist(id, newName);
    }

    public int getWishlistIdByWishId(int wishId) {
        return wishlistRepository.getWishlistIdByWishId(wishId);
    }

    public List<Wishlist> getWishlistsByUserId(int userId) {
        return wishlistRepository.getWishlistsByUserId(userId);
    }
}
