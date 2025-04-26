package com.example.CrudApp.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.Cart;
@Repository
public class CartRepositoryIMPL implements CartRepository{
	 @Autowired
	    JdbcTemplate jdbcTemplate;

	    @Override
	    public void addToCart(Cart cart) {
	        String sql = "INSERT INTO cart (userId, prodId, quantity) VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, cart.getUserId(), cart.getProdId(), cart.getQuantity());
	    }

	    @Override
	    public List<Cart> getCartByUserId(int userId) {
	        String sql = "SELECT * FROM cart WHERE userId = ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cart.class), userId);
	    }
           
	    @Override
	    public void removeItemFromCart(int cartId) {
	        String sql = "DELETE FROM cart WHERE cartId = ?";
	        jdbcTemplate.update(sql, cartId);
	    }
	    
	    @Override
	    public void updateQuantity(Cart cart) {
	        String sql = "UPDATE cart SET quantity = ? WHERE cartId = ?";
	        jdbcTemplate.update(sql, cart.getQuantity(), cart.getCartId());
	    }

}
