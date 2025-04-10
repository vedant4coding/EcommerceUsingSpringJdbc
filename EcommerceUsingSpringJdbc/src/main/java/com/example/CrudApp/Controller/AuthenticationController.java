package com.example.CrudApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CrudApp.Model.User;
import com.example.CrudApp.Service.AuthenticationService;
import com.example.CrudApp.Service.RegistrationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private RegistrationService registrationServiceImpl;
	
	@PostMapping("/registration")
	public String UserRegistration(@RequestBody User user) {
		boolean isCompleted = registrationServiceImpl.isRegistered(user);
		return isCompleted ? "Registered Successfully" : "Already registered";
	}
	
	@Autowired
	private AuthenticationService authenticationServiceImpl;
	
	@PostMapping("/login")
	public String AdminLogin(@RequestBody User user) {
		
		String result = authenticationServiceImpl.UserLogin(user);
		if ("admin-dashboard".equals(result)) {
	        return "redirect:/admin/dashboard";
	    } else if ("buyer-dashboard".equals(result)) {
	        return "redirect:/buyer/dashboard";
	    } else if ("seller-dashboard".equals(result)) {
	        return "redirect:/seller/dashboard";
	    } else if ("invalid-login".equals(result)) {
	        return "login again"; 
	    } else {
	        return "login failed";
	    }
	}
}
