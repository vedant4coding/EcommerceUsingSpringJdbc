package com.example.CrudApp.Service;

import java.util.List;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.Product;
import com.example.CrudApp.Model.User;
import com.example.CrudApp.Model.ViewCategoryDto;

public interface AdminService {

	List<User> viewAllUsers();

	List<User> viewSellers();
	
	List<User> viewBuyers();

	List<User> searchUsers(String keyword);

	User searchUserById(int userId);

	boolean deleteUser(int userId);

	boolean addCategory(Category category);

	List<ViewCategoryDto> viewCategories();
	
	Product searchProductByName(String prodname);
}
