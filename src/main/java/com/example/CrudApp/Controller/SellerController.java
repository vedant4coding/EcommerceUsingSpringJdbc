package com.example.CrudApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerService sellerServiceImpl;

	@PostMapping("/addCategory")
	public String AddCategory(Category category) {
		boolean isCategoryAdded = sellerServiceImpl.isAddCategory(category);
		return isCategoryAdded?"Category Added" : "Category not added";
	}
}
