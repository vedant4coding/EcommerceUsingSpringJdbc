package com.example.CrudApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudApp.Model.User;
import com.example.CrudApp.Repository.AuthenticationRepository;
@Service
public class AuthenticationServiceIMPL implements AuthenticationService{
	
	@Override
	public boolean isRegistered(User user) {
		// TODO Auto-generated method stub
		return authenticationRepositoryImpl.isRegistered(user);
	}
	@Autowired
	private AuthenticationRepository authenticationRepositoryImpl;
	@Override
	public String UserLogin(User user) {
		return authenticationRepositoryImpl.isUserLogin(user);
	}
	@Override
	public boolean isUserLogout(int userId) {
		// TODO Auto-generated method stub
		return authenticationRepositoryImpl.isUserLogout(userId);
	}

}
