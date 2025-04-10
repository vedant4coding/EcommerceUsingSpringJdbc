package com.example.CrudApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudApp.Model.User;
import com.example.CrudApp.Repository.RegistrationRepository;
@Service
public class RegistrationServiceIMPL implements RegistrationService{

	@Autowired
	private RegistrationRepository registrationRepositoryImpl;
	@Override
	public boolean isRegistered(User user) {
		// TODO Auto-generated method stub
		return registrationRepositoryImpl.isRegistered(user);
	}

}
