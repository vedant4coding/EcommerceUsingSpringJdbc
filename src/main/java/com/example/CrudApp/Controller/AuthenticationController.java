package com.example.CrudApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.CrudApp.Model.User;
import com.example.CrudApp.Service.AuthenticationService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationServiceImpl;
	@PostMapping("/registration")
	public String UserRegistration(@RequestBody User user) {
		boolean isCompleted = authenticationServiceImpl.isRegistered(user);
		return isCompleted ? "Registered Successfully" : "Already registered";
	}
	
	
	@PostMapping("/login")
	public String AdminLogin(@RequestBody User user) {
		
		String result = authenticationServiceImpl.UserLogin(user);
		if ("admin-dashboard".equals(result)) {
	        return "redirect:/admin/dashboard";
	    } else if ("buyer-dashboard".equals(result)) {
	        return "redirect:/buyer/dashboard";
	    } else if ("seller-dashboard".equals(result)) {
	        return "redirect:/seller/dashboard";
	    }  else if ("Already logged in".equals(result)) {
	        return "already logged in"; 
	    } else if ("invalid-login".equals(result)) {
	        return "login again"; 
	    } else {
	        return "login failed";
	    }
	}
	
	@PostMapping("/logout")
    public String logout(@RequestParam int userId) {
		boolean result = authenticationServiceImpl.isUserLogout(userId);
        return result ? "Logged out successfully" : "Logout failed";
    }
	
	
}
