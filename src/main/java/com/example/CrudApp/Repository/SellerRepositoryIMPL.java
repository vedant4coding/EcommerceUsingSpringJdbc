package com.example.CrudApp.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.AddProductDto;
import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.EditProductDto;
@Repository
public class SellerRepositoryIMPL implements SellerRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean isAddCategory(Category category) {
		String sql = "Insert into categories (categoryname) values (?)";
		int result = jdbcTemplate.update(sql,category.getCategoryname());
		return result>0;
	}

	@Override
	public boolean isAddProduct(AddProductDto addProduct) {
		String prodCategory = addProduct.getCategoryname();
		Integer categoryId = null;
		try {
		    categoryId = jdbcTemplate.queryForObject(
		        "SELECT categoryId FROM categories WHERE categoryname = ?",
		        Integer.class,
		        prodCategory
		    );
		} catch (EmptyResultDataAccessException e) {
		    // Handle missing category
		    System.out.println("Category not found: " + prodCategory);
		}
		String sql = "Insert into products (prodname, proddesc, price, discount, quantity, categoryId, sellerId) values (?, ?, ?, ?, ?, ?, ?)";
		int value = jdbcTemplate.update(sql, addProduct.getProdname(),addProduct.getProddesc(),addProduct.getPrice(),addProduct.getDiscount(),addProduct.getQuantity(),categoryId,1);
		
		return value>0;
	}
	
	
	public boolean editProduct(EditProductDto editProduct) {
	    StringBuilder sql = new StringBuilder("UPDATE products SET ");
	    List<Object> params = new ArrayList<>();

	    if (editProduct.getProdName() != null) {
	        sql.append("prodname = ?, ");
	        params.add(editProduct.getProdName());
	    }
	    if (editProduct.getProdDesc() != null) {
	        sql.append("proddesc = ?, ");
	        params.add(editProduct.getProdDesc());
	    }
	    if (editProduct.getPrice() != null) {
	        sql.append("price = ?, ");
	        params.add(editProduct.getPrice());
	    }
	    if (editProduct.getQuantity() != null) {
	        sql.append("quantity = ?, ");
	        params.add(editProduct.getQuantity());
	    }
	    if (editProduct.getDiscount() != null) {
	        sql.append("discount = ?, ");
	        params.add(editProduct.getDiscount());
	    }

	    // Remove the last comma
	    if (params.isEmpty()) {
	        return false; // Nothing to update
	    }

	    sql.setLength(sql.length() - 2); // remove trailing comma and space
	    sql.append(" WHERE prodId = ?");
	    params.add(editProduct.getProdId());

	    int rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
	    return rowsAffected > 0;
	}
	
	
	public boolean deleteProduct(int prodId) {
		String sql = "delete from products where prodId = ?";
	    int value = jdbcTemplate.update(sql,prodId);
		return value>0;
	}

}
