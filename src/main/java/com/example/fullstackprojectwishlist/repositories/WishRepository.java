package com.example.fullstackprojectwishlist.repositories;

import com.example.fullstackprojectwishlist.models.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class WishRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Add wish
    public void addWish(@RequestParam int wishlistId, String wishName, String wishDescription, double price) {
        String query = "INSERT INTO wish(wishlist_id, wish_name, wish_description, price) " +
                "VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(query, wishlistId, wishName, wishDescription, price);
    }

    // Get a single wish by wishId
    public Wish getWishById(int wishId) {
        String query = "SELECT * FROM wish WHERE wish_id = ?;";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.queryForObject(query, rowMapper, wishId);
    }

    // Update wish by wishId
    public void updateWishById(int wishId, int wishlistId, String wishName, String wishDescription, double price) {
        String query = "UPDATE wish " +
                "SET wishlist_id = ?, " +
                "wish_name = ?," +
                "wish_description = ?," +
                "price = ? " +
                "WHERE wish_id = ?;";
        jdbcTemplate.update(query, wishlistId, wishName, wishDescription, price, wishId);
    }

    public List<Wish> getAllWishesByWishlistId(@RequestParam int wishlistId) {
        String query = "SELECT * FROM wish WHERE wishlist_id = ?";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wish.class);
        return jdbcTemplate.query(query, rowMapper, wishlistId);
    }

    public void deleteWishById(int wishId) {
        String query = "DELETE FROM wish WHERE wish_id = ?;";
        jdbcTemplate.update(query, wishId);
    }
}
