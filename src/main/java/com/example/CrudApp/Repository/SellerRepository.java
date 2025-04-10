package com.example.CrudApp.Repository;

import com.example.CrudApp.Model.AddProductDto;
import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.EditProductDto;

public interface SellerRepository {
	public boolean isAddCategory(Category category);
	public boolean isAddProduct(AddProductDto addProduct);
	public boolean editProduct(EditProductDto editProduct);
}
