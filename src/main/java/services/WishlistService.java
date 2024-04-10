package services;

import models.Wishlist;
import org.springframework.stereotype.Service;
import repositories.WishlistRepository;

import java.util.List;

@Service
public class WishlistService {
    private WishlistRepository wishlistRepository;

    public void addWishlist(int userId, String wishlistName) {
        wishlistRepository.addWishlist(userId, wishlistName);
    }

    public void deleteWishlist(int wishlistId){
        wishlistRepository.deleteWishlist(wishlistId);
    }

    public List<Wishlist> getWishlists(){
        return wishlistRepository.getAllWishlists();
    }

    public Wishlist getWishlist(int wishlistID){
        return wishlistRepository.getWishlist(wishlistID);
    }
}
