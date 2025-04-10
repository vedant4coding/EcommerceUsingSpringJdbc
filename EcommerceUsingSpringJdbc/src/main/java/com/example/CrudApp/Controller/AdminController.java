package com.example.CrudApp.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApp.Model.*;
import com.example.CrudApp.Service.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminServiceImpl;
	@PostMapping("/viewAllUsers")
	public List<User> viewAllUsers(){
		return adminServiceImpl.viewAllUsers();
	}
	
	@PostMapping("/viewSellers")
	public List<User> viewSellers(){
		return adminServiceImpl.viewSellers();
	}

	@PostMapping("/viewBuyers")
	public List<User> viewBuyers(){
		return adminServiceImpl.viewBuyers();
	}
	
	@PostMapping("/searchUsers")
	public List<User> searchUsers(@RequestParam String keyword) {
	    return adminServiceImpl.searchUsers(keyword);
	}
	
	@GetMapping("/searchUserById")
	public ResponseEntity<User> searchUserById(@RequestParam int userId) {
	    User user = adminServiceImpl.searchUserById(userId);
	    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}// to check on postman
	//localhost:8080/admin/searchUserById?userId=2
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam int userId) {
	    boolean isDeleted = adminServiceImpl.deleteUser(userId);
	    if (isDeleted) {
	        return ResponseEntity.ok("User deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or deletion failed");
	    }
	}
	
	@PostMapping("/viewCategories")
	public List<Category> viewCategories(){
		return adminServiceImpl.viewCategories();
	}

	
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody Category category) {
	    boolean added = adminServiceImpl.addCategory(category);
	    return added ? "Category Added" : "Failed to Add Category";
	}
}
