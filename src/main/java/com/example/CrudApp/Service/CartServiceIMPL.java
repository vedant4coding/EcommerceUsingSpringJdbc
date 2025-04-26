package com.example.CrudApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudApp.Model.Cart;
import com.example.CrudApp.Repository.CartRepository;

@Service
public class CartServiceIMPL implements CartService{

	 @Autowired
	    private CartRepository cartRepository;

	    @Override
	    public void addToCart(Cart cart) {
	        cartRepository.addToCart(cart);
	    }

	    @Override
	    public List<Cart> getCartByUserId(int userId) {
	        return cartRepository.getCartByUserId(userId);
	    }

	    @Override
	    public void removeItemFromCart(int cartId) {
	        cartRepository.removeItemFromCart(cartId);
	    }
	    
	    @Override
	    public void updateQuantity(Cart cart) {
	        cartRepository.updateQuantity(cart);
	    }

}
