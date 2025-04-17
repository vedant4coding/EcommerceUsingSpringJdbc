package com.example.CrudApp.Service;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.example.CrudApp.Model.Product;
import com.example.CrudApp.Model.ViewCategoryDto;
import com.example.CrudApp.Model.ViewProductDto;
import com.example.CrudApp.Repository.BuyerRepository;

@Service
public class BuyerServiceIMPL implements BuyerService {
	@Autowired
	BuyerRepository buyerRepositoryImpl;

	@Value("${product.image}")
	private String imagesPath;

	@SuppressWarnings("null")
	@Override
	public List<ViewProductDto> viewProducts() {
//		
		List<Product> list = buyerRepositoryImpl.isViewProducts();
		List<ViewProductDto> newList = new ArrayList<>();

		for (Product product : list) {
			ViewProductDto vdt = new ViewProductDto();
			vdt.setProdname(product.getProdname());
			vdt.setPrice(product.getPrice());
			vdt.setDiscount(product.getDiscount());
			vdt.setProddesc(product.getProddesc());
			vdt.setQuantity(product.getQuantity());
			vdt.setRating(product.getRating());
			vdt.setSellerId(product.getSellerid());

			// ✅ Build image URL instead of converting to MultipartFile
			String imgName = product.getProductImgName();
			String imageUrl = "http://localhost:8080/images/productImages/" + imgName;
			vdt.setImageUrl(imageUrl);

			newList.add(vdt);
		}
		return newList;
	}

	@Override
	public List<ViewCategoryDto> viewCategories() {
		List<ViewCategoryDto> list = buyerRepositoryImpl.isViewCategories();
		List<ViewCategoryDto> newList = new ArrayList<>();

		for (ViewCategoryDto category : list) {
			ViewCategoryDto vct = new ViewCategoryDto();
			vct.setCategoryId(category.getCategoryId());
			vct.setCategoryname(category.getCategoryname());

			String imgName = category.getCategoryImgName();
			String categoryImageUrl = "http://localhost:8080/images/categoryImages/" + imgName;
			vct.setCategoryImageUrl(categoryImageUrl);

			newList.add(vct);
		}
		return newList;
	}

	@Override
	public List<ViewProductDto> viewProductsByCategoryId(int categoryId) {
		List<ViewProductDto> list = buyerRepositoryImpl.isViewProductsByCategoryId(categoryId);
		List<ViewProductDto> newList = new ArrayList<>();

		for (ViewProductDto product : list) {
			ViewProductDto vdt = new ViewProductDto();
			vdt.setProdId(product.getProdId());
			vdt.setProdname(product.getProdname());
			vdt.setPrice(product.getPrice());
			vdt.setDiscount(product.getDiscount());
			vdt.setProddesc(product.getProddesc());
			vdt.setQuantity(product.getQuantity());
			vdt.setRating(product.getRating());
			vdt.setSellerId(product.getSellerId());

			// ✅ Build image URL instead of converting to MultipartFile
			String imgName = product.getProductImgName();
			String imageUrl = "http://localhost:8080/images/productImages/" + imgName;
			vdt.setImageUrl(imageUrl);

			newList.add(vdt);
		}
		return newList;
	}
}
