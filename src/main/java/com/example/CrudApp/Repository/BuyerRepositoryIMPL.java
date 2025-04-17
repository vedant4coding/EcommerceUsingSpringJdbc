package com.example.CrudApp.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.CrudApp.Model.Category;
import com.example.CrudApp.Model.Product;
import com.example.CrudApp.Model.ViewCategoryDto;
import com.example.CrudApp.Model.ViewProductDto;
@Repository
public class BuyerRepositoryIMPL implements BuyerRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Product> isViewProducts() {
		String sql = "select * from products";
		List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
		return list;
	}

	@Override
	public List<ViewCategoryDto> isViewCategories() {
		String sql = "select * from categories";
		List<ViewCategoryDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ViewCategoryDto.class));
		return list;
	}

	@Override
	public List<ViewProductDto> isViewProductsByCategoryId(int categoryId) {
		String sql = "select * from products where categoryId = ?";
		List<ViewProductDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ViewProductDto.class),categoryId);
		return list;
	}

}
