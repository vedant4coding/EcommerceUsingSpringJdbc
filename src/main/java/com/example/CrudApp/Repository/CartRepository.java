package com.example.CrudApp.Repository;

import java.util.List;

import com.example.CrudApp.Model.Cart;

public interface CartRepository {
	void addToCart(Cart cart);
    List<Cart> getCartByUserId(int userId);
    void removeItemFromCart(int cartId);
    void updateQuantity(Cart cart);

}
