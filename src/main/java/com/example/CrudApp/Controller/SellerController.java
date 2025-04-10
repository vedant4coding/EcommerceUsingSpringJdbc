package com.example.CrudApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApp.Model.AddProductDto;
import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.EditProductDto;
import com.example.CrudApp.Service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerService sellerServiceImpl;

	@PostMapping("/addCategory")
	public String AddCategory(@RequestBody Category category) {
		boolean isCategoryAdded = sellerServiceImpl.isAddCategory(category);
		return isCategoryAdded?"Category Added" : "Category not added";
	}
	
	@PostMapping("/addProduct")
	public String AddProduct(@RequestBody AddProductDto addProduct) {
		boolean isProductAdded = sellerServiceImpl.isAddProduct(addProduct);
		return isProductAdded?"Product Added" : "Product not added";
	}
	
	@PostMapping("/editProduct")
	public String editProduct(@RequestBody EditProductDto editProduct) {
		boolean isProductAdded = sellerServiceImpl.editProduct(editProduct);
		return isProductAdded?"Product Added" : "Product not added";
	}
}
