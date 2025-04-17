package com.example.CrudApp.Service;

import java.util.List;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.User;

public interface AdminService {

	List<User> viewAllUsers();

	List<User> viewSellers();
	
	List<User> viewBuyers();

	List<User> searchUsers(String keyword);

	User searchUserById(int userId);

	boolean deleteUser(int userId);

	boolean addCategory(Category category);

	List<Category> viewCategories();
}
