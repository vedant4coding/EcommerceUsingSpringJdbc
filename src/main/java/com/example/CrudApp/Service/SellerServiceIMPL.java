package com.example.CrudApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Repository.SellerRepository;

@Service
public class SellerServiceIMPL implements SellerService{
	@Autowired
	private SellerRepository sellerRepositoryImpl;

	@Override
	public boolean isAddCategory(Category category) {
		// TODO Auto-generated method stub
		return sellerRepositoryImpl.isAddCategory(category);
	}
	
	

}
