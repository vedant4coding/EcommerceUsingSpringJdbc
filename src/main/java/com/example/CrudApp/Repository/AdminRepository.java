package com.example.CrudApp.Repository;

import java.util.List;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.Product;
import com.example.CrudApp.Model.User;
import com.example.CrudApp.Model.ViewCategoryDto;

public interface AdminRepository {

	List<User> viewAllUsers();

	List<User> viewSellers();

	List<User> viewBuyers();

	List<User> searchUsers(String keyword);

	User searchUserById(int userId);
	
	Product searchProductByName(String prodname);

	boolean deleteUser(int userId);

	boolean addCategory(Category category);

	List<ViewCategoryDto> viewCategories();
	

}
