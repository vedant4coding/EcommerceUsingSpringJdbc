package com.example.CrudApp.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.User;
@Repository
public class AuthenticationRepositoryIMPL implements AuthenticationRepository{

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public String isUserLogin(User user) {
		String sql = "SELECT usertype FROM Users WHERE username = ? AND password = ?";
	    String object = jdbcTemplate.queryForObject(sql, String.class, user.getUsername(), user.getPassword());
	    if (object != null) {
	        String type = object;
	        System.out.println(type);
	        switch (type.toUpperCase()) {
	            case "ADMIN":
	                return "admin-dashboard";
	            case "BUYER":
	                return "buyer-dashboard";
	            case "SELLER":
	                return "seller-dashboard";
	            default:
	                return "unknown-role";
	        }
	    }
	    return "invalid-login";
	}
}
