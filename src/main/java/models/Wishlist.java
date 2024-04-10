package models;

public class Wishlist {
    private int wishlistId;
    private int userId;
    private String wishlistName;

    public Wishlist() {
    }

    public Wishlist(int wishlistId, int userId, String wishlistName) {
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.wishlistName = wishlistName;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}
