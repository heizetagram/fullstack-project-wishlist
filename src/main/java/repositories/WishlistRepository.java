package repositories;
import models.Wishlist;
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
        String query = "DELETE FROM wishlist WHERE wishlistId = ?";
        jdbcTemplate.update(query, wishlistId);
    }

    public List getAllWishlists(){
        String query = "SELECT * FROM wishlist";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wishlist.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public Wishlist getWishlist(int wishlistID) {
        String query = "SELECT * FROM wishlist WHERE wishlist_id = ?";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.queryForObject(query, rowMapper, wishlistID);
    }
}
