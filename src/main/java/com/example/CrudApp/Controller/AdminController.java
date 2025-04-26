package com.example.CrudApp.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApp.Model.*;
import com.example.CrudApp.Service.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminServiceImpl;
	@GetMapping("/viewAllUsers")
	public List<User> viewAllUsers(){
		return adminServiceImpl.viewAllUsers();
	}
	
	@GetMapping("/viewSellers")
	public List<User> viewSellers(){
		return adminServiceImpl.viewSellers();
	}

	@GetMapping("/viewBuyers")
	public List<User> viewBuyers(){
		return adminServiceImpl.viewBuyers();
	}
	
	@PostMapping("/searchUsers")

	public List<User> searchUsers(@RequestBody Map<String,String> payload) {
		String keyword = payload.get("keyword");
	    return adminServiceImpl.searchUsers(keyword);
	}

	
	@GetMapping("/searchUserById")
	public ResponseEntity<User> searchUserById(@RequestParam int userId) {
	    User user = adminServiceImpl.searchUserById(userId);
	    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/searchProductByName")
	public ResponseEntity<Product> searchProductByName(@RequestParam String prodname){
//	    System.out.println("Received prodname: [" + prodname + "]");
		Product prod = adminServiceImpl.searchProductByName(prodname);
		return prod !=null ? ResponseEntity.ok(prod) : ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam int userId) {
	    boolean isDeleted = adminServiceImpl.deleteUser(userId);
	    if (isDeleted) {
	        return ResponseEntity.ok("User deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or deletion failed");
	    }
	}
	
	@GetMapping("/viewCategories")
	public List<ViewCategoryDto> viewCategories(){
		return adminServiceImpl.viewCategories();
	}
	
	@Value("${category.image}")
    private String categoryImagesPath;
    
    @GetMapping("/categoryImages/{imageName}")
    public ResponseEntity<InputStreamResource> getCategoryImage(@PathVariable String imageName) throws IOException {
        File file = new File(categoryImagesPath + File.separator + imageName);

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + imageName)
                .contentLength(file.length())
                .contentType(MediaType.IMAGE_JPEG) // You can change this based on your image type
                .body(resource);
    }

	
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody Category category) {
	    boolean added = adminServiceImpl.addCategory(category);
	    return added ? "Category Added" : "Failed to Add Category";
	}
}
