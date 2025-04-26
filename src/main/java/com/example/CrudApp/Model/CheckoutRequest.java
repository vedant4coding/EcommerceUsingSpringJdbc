package com.example.CrudApp.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {
    private String email;
    private String message;
    private List<Cart> cartItems;
    private double totalPrice;
}
