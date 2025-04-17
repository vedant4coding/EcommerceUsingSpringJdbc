package com.example.CrudApp.Repository;

import java.io.IOException;
import java.util.List;

import com.example.CrudApp.Model.AddCategoryDto;
import com.example.CrudApp.Model.AddProductDto;
import com.example.CrudApp.Model.EditProductDto;
import com.example.CrudApp.Model.Product;

public interface SellerRepository {
	public boolean isAddCategory(AddCategoryDto addCategory);
	public boolean isAddProduct(AddProductDto addProduct) throws IOException;
	public boolean editProduct(EditProductDto editProduct);
	public boolean deleteProduct(int prodId);
	public List<Product> isViewProducts(int sellerId);
}
