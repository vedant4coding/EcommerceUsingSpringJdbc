package com.example.CrudApp.Service;

import com.example.CrudApp.Model.User;

public interface AuthenticationService {
	public boolean isRegistered(User user);
	public String UserLogin(User user);
	public boolean isUserLogout(int userId);
}
