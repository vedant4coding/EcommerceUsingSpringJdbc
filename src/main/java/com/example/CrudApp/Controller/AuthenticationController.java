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
		String arr[] = new String[3];
		String result = authenticationServiceImpl.UserLogin(user);
		arr = result.split("/");
		if ("admin-dashboard".equals(arr[0])) {
	        return "redirect:-admin-dashboard/"+ arr[1]+"/"+arr[2];
	    } else if ("buyer-dashboard".equals(arr[0])) {
	        return "redirect:-buyer-dashboard/"+ arr[1]+"/"+arr[2];
	    } else if ("seller-dashboard".equals(arr[0]) && !arr[1].isEmpty()) {
	        return "redirect:-seller-dashboard/"+ arr[1]+"/"+arr[2];
	    }  else if ("Already logged in".equals(arr[0])) {
	        return "already logged in"; 
	    } else if ("invalid-login".equals(arr[0])) {
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
