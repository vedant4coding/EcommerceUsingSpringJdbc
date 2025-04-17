package com.example.CrudApp.Service;

import java.io.IOException;
import java.util.List;

import com.example.CrudApp.Model.AddCategoryDto;
import com.example.CrudApp.Model.AddProductDto;
import com.example.CrudApp.Model.EditProductDto;
import com.example.CrudApp.Model.ViewProductDto;

public interface SellerService {
	
	public boolean isAddCategory(AddCategoryDto dto) throws IOException;
	public boolean isAddProduct(AddProductDto addProduct) throws IOException;
	public boolean editProduct(EditProductDto editProduct) throws IOException;
	public boolean deleteProduct(int prodId);
	public List<ViewProductDto> viewProductOfSeller(int sellerId);
}
