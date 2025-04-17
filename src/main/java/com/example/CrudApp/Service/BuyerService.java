package com.example.CrudApp.Service;

import java.util.List;

import com.example.CrudApp.Model.Product;
import com.example.CrudApp.Model.ViewCategoryDto;
import com.example.CrudApp.Model.ViewProductDto;

public interface BuyerService {
	public List<ViewProductDto> viewProducts();

	public List<ViewCategoryDto> viewCategories();
	
	public List<ViewProductDto> viewProductsByCategoryId(int categoryId);
}
