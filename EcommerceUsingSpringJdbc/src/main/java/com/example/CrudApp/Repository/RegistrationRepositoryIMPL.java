package com.example.CrudApp.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.User;
@Repository
public class RegistrationRepositoryIMPL implements RegistrationRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean isRegistered(User user) {
	    String sql = "INSERT INTO users (username, name, email, contact, password, usertype, address) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    int value = jdbcTemplate.update(sql,
	        user.getUsername(),
	        user.getName(),
	        user.getEmail(),
	        user.getContact(),
	        user.getPassword(),
	        user.getUsertype(),
	        user.getAddress()
	    );

	    return value > 0;
	}
}
