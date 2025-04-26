package com.example.CrudApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApp.Model.Cart;
import com.example.CrudApp.Service.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Cart")
public class CartController {
	@Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody Cart cart) {
        cartService.addToCart(cart);
        return "Item added to cart successfully.";
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getUserCart(@PathVariable int userId) {
    	List<Cart> addcart = cartService.getCartByUserId(userId);
        return addcart;
    }

    @DeleteMapping("/remove/{cartId}")
    public String removeItem(@PathVariable int cartId) {
        cartService.removeItemFromCart(cartId);
        System.out.println("Item with cartId " + cartId + " removed successfully.");

        return "Item removed from cart.";
  }
    
    @PutMapping("/updateQuantity")
    public String updateQuantity(@RequestBody Cart cart) {
        cartService.updateQuantity(cart);
        return "Quantity updated successfully.";
    }

}
