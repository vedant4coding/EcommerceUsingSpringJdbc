package com.example.CrudApp.Service;

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
	public List<Category> viewCategories() {
		// TODO Auto-generated method stub
		return adminRepository.viewCategories();
	}


}
