package com.example.CrudApp.Service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String email, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);         // Receiver: user's email
        message.setSubject(subject);  // Email subject
        message.setText(body);        // Email content

        mailSender.send(message);     // Send the email
    }
}
