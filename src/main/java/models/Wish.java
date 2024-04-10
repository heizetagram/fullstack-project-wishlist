package models;

public class Wish {
    private int wishId;
    private int wishlistId;
    private String wishName;
    private String wishDescription;
    private double price;

    public Wish() {
    }

    public Wish(int productId, String wishName, String wishDescription, double price) {
        this.wishId = productId;
        this.wishName = wishName;
        this.wishDescription = wishDescription;
        this.price = price;
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public String getWishDescription() {
        return wishDescription;
    }

    public void setWishDescription(String wishDescription) {
        this.wishDescription = wishDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
