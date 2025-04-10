package com.example.CrudApp.Repository;

import com.example.CrudApp.Model.User;

public interface AuthenticationRepository {
	public boolean isRegistered(User user);
	public String isUserLogin(User user);
	public boolean isUserLogout(int userId);
}
