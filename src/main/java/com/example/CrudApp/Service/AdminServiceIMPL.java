package com.example.CrudApp.Service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.CrudApp.Model.*;
import com.example.CrudApp.Repository.AdminRepository;

@Service
public class AdminServiceIMPL implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return adminRepository.viewAllUsers();
	}

	@Override
	public List<User> viewSellers() {
		// TODO Auto-generated method stub
		return adminRepository.viewSellers();
	}
	
	@Override
	public List<User> viewBuyers() {
		// TODO Auto-generated method stub
		return adminRepository.viewBuyers();
	}

	@Override
	public List<User> searchUsers(String keyword) {
	    return adminRepository.searchUsers(keyword);
	}

	@Override
	public User searchUserById(int userId) {
	    return adminRepository.searchUserById(userId);
	}

	@Override
	public boolean deleteUser(int userId) {
	    return adminRepository.deleteUser(userId);
	}

	@Override
	public boolean addCategory(Category category) {
	    return adminRepository.addCategory(category);
	}

	@Override
	public List<ViewCategoryDto> viewCategories() {
		List<ViewCategoryDto> list = adminRepository.viewCategories();
		List<ViewCategoryDto> newList = new ArrayList<>();

		for (ViewCategoryDto category : list) {
			ViewCategoryDto vct = new ViewCategoryDto();
			vct.setCategoryId(category.getCategoryId());
			vct.setCategoryname(category.getCategoryname());

			// ✅ Build image URL instead of converting to MultipartFile
			String imgName = category.getCategoryImgName();
			String imageUrl = "http://localhost:8080/images/categoryImages/" + imgName;
			vct.setCategoryImageUrl(imageUrl);

			newList.add(vct);
		}
		return newList;
	}

	@Override
	public Product searchProductByName(String prodname) {
		return adminRepository.searchProductByName(prodname);
	}


}
