package com.example.CrudApp.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.User;

@Repository
public class AdminRepositoryIMPL implements AdminRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<User> viewAllUsers() {
	    String sql = "SELECT * FROM users";
	    List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	    return userList;
	}
	
	@Override
	public List<User> viewSellers() {
	    String sql1 = "SELECT * FROM users where usertype = ?";
	    List<User> sellerList = jdbcTemplate.query(sql1, new BeanPropertyRowMapper<>(User.class),"SELLER");
	    return sellerList;
	}

	@Override
	public List<User> viewBuyers() {
		String sql2 = "SELECT * FROM users where usertype = ?";
	    List<User> buyerList = jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(User.class),"BUYER");
	    return buyerList;
	}
	
	@Override
	public List<User> searchUsers(String keyword) {
	    String sql = "SELECT * FROM users WHERE " +
	            "username LIKE ? OR " +
	            "name LIKE ? OR " +
	            "email LIKE ? OR " +
	            "contact LIKE ? OR " +
	            "usertype LIKE ? OR " +
	            "address LIKE ? OR " + 
	            "userId = ?";
	    
	    String searchPattern = "%" + keyword + "%";
	    
	    return jdbcTemplate.query(
	            sql,
	            new BeanPropertyRowMapper<>(User.class),
	            searchPattern, searchPattern, searchPattern, searchPattern, searchPattern, searchPattern,searchPattern
	    );
	}

	
	@Override
	public User searchUserById(int userId) {
	    String sql = "SELECT * FROM users WHERE userId = ?";
	    try {
	        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
	    } catch (EmptyResultDataAccessException e) {
	        return null; // User not found
	    }
	}


	@Override
	public boolean deleteUser(int userId) {
	    String sql = "DELETE FROM users WHERE userId = ?";
	    int rowsAffected = jdbcTemplate.update(sql, userId);
	    return rowsAffected > 0;
	}

	@Override
	public boolean addCategory(Category category) {
	    String sql = "INSERT INTO categories (categoryname) VALUES (?)";
	    int rows = jdbcTemplate.update(sql, category.getCategoryname());
	    return rows > 0;
	}

	@Override
	public List<Category> viewCategories() {
		String sql = "SELECT * FROM categories";
		List<Category> categoryList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
	    return categoryList;
	}


}
