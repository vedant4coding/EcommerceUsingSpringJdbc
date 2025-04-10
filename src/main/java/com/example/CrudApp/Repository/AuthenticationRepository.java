package com.example.CrudApp.Repository;

import com.example.CrudApp.Model.User;

public interface AuthenticationRepository {
	public String isUserLogin(User user);
}
