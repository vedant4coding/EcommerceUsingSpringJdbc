package com.example.CrudApp.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.Category;
@Repository
public class SellerRepositoryIMPL implements SellerRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean isAddCategory(Category category) {
		String sql = "Insert into categories (categoryname) values (?)";
		int result = jdbcTemplate.update(sql,category.getCategoryname());
		return result>0;
	}
}
