package com.example.CrudApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApp.Model.*;
import com.example.CrudApp.Service.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/ping")
	public String test() {
	    return "Admin Controller is up!";
	}


}
