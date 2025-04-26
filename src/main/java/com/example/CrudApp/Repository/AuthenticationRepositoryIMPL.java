package com.example.CrudApp.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.User;

@Repository
public class AuthenticationRepositoryIMPL implements AuthenticationRepository {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
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

	@Override
	public String isUserLogin(User user) {

		String loginStatusSql = "SELECT loginstatus FROM users WHERE username = ? AND password = ?";
		Integer status = jdbcTemplate.queryForObject(loginStatusSql, Integer.class, user.getUsername(),
				user.getPassword());

		System.out.println(status);

		if (status != null && status == 1) {
			return "Already logged in";
		}

		String sql = "SELECT usertype FROM Users WHERE username = ? AND password = ?";
		String userType = jdbcTemplate.queryForObject(sql, String.class, user.getUsername(), user.getPassword());

		String sql1 = "SELECT userId FROM Users WHERE username = ? AND password = ?";
		int userId = jdbcTemplate.queryForObject(sql1, Integer.class, user.getUsername(), user.getPassword());

		String emailSql = "SELECT email FROM users WHERE username = ? AND password = ?";
        String email = jdbcTemplate.queryForObject(emailSql, String.class, user.getUsername(), user.getPassword());
		
		String updateSql = "UPDATE Users SET loginstatus = ? WHERE userId = ?";
		int rowsUpdated = jdbcTemplate.update(updateSql, 1, userId);
		System.out.println(user.getLoginstatus());

		if (rowsUpdated > 0) {
			// 3. Return dashboard based on user type
			switch (userType.toUpperCase()) {
			case "ADMIN":
				return "admin-dashboard/"+userId+ "/"+ email;
			case "BUYER":
				return "buyer-dashboard/"+userId+ "/"+ email;
			case "SELLER":
				return "seller-dashboard/"+userId+ "/"+ email;
			default:
				return "unknown-role/";
			}
		}
		return "invalid-login/";
	}

	public boolean isUserLogout(int userId) {
		String sql = "UPDATE users SET loginstatus = ? WHERE userId = ?";
		int result = jdbcTemplate.update(sql, 0, userId);
		return result > 0 ? true : false;
	}
}
