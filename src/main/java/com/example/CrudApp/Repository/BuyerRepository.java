package com.example.CrudApp.Repository;

import java.util.List;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.Product;
import com.example.CrudApp.Model.ViewProductDto;

public interface BuyerRepository {
	public List<Product> isViewProducts();
	public List<Category> isViewCategories();
	public List<ViewProductDto> isViewProductsByCategoryId(int categoryId);
}
