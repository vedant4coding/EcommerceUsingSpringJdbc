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
			String imageUrl = "http://localhost:8080/Buyer/images/" + imgName;
			vdt.setImageUrl(imageUrl);

			newList.add(vdt);
		}
		return newList;
	}

	@Override
	public List<ViewCategoryDto> viewCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewProductDto> viewProductsByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
