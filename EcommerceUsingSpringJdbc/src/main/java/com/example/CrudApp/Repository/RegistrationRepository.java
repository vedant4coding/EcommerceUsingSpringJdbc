package com.example.CrudApp.Repository;

import com.example.CrudApp.Model.User;

public interface RegistrationRepository {
	
	public boolean isRegistered(User user);
}
