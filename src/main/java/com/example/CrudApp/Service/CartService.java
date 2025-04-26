package com.example.CrudApp.Service;

import java.util.List;

import com.example.CrudApp.Model.Cart;

public interface CartService {
	void addToCart(Cart cart);
    List<Cart> getCartByUserId(int userId);
    void removeItemFromCart(int cartId);
    void updateQuantity(Cart cart);

}
