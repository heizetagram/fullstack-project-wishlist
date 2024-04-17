package com.example.fullstackprojectwishlist.repositories;
import com.example.fullstackprojectwishlist.models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishlistRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addWishlist(int userId, String wishlistName){
        String query = "INSERT INTO wishlist (user_id, wishlist_name) VALUES (?,?)";
        jdbcTemplate.update(query, userId, wishlistName);
    }

    public void deleteWishlist(int wishlistId){
        String query = "DELETE FROM wishlist WHERE wishlist_id = ?";
        jdbcTemplate.update(query, wishlistId);
    }

    public Wishlist getWishlist(int wishlistID) {
        String query = "SELECT * FROM wishlist WHERE wishlist_id = ?";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.queryForObject(query, rowMapper, wishlistID);
    }

    public void updateWishlist(int id, String newName) {
        String query = "UPDATE wishlist SET wishlist_name = ? WHERE wishlist_id = ?";
        jdbcTemplate.update(query, newName, id);
    }

    public int getWishlistIdByWishId(int wishId) {
        String query = "SELECT wishlist_id FROM wish WHERE wish_id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, wishId);
    }

    public List<Wishlist> getWishlistsByUserId(int userId) {
        String query = "SELECT * FROM wishlist WHERE user_id = ?";
        RowMapper rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.query(query, rowMapper, userId);
    }
}
