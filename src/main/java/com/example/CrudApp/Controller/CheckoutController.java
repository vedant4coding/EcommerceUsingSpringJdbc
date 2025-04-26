package com.example.CrudApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.CrudApp.Model.CheckoutRequest;
import com.example.CrudApp.Service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String checkout(@RequestBody CheckoutRequest request) {
        try {
            emailService.sendEmail(
                request.getEmail(),         // Receiver's email (user)
                "Order Confirmation",       // Email subject
                request.getMessage()        // Email body/message
            );
            return "Email sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send email.";
        }
    }
}
