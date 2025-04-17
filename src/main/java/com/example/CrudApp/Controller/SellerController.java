package com.example.CrudApp.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.CrudApp.Model.AddCategoryDto;
import com.example.CrudApp.Model.AddProductDto;
import com.example.CrudApp.Model.EditProductDto;
import com.example.CrudApp.Model.ViewProductDto;
import com.example.CrudApp.Service.SellerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerService sellerServiceImpl;

	@PostMapping(value = "/addCategory", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String AddCategory(@RequestParam("categoryData") String categoryJson, @RequestParam("categoryfile") MultipartFile file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		AddCategoryDto dto = mapper.readValue(categoryJson, AddCategoryDto.class);
		dto.setFile(file);
		boolean isCategoryAdded = sellerServiceImpl.isAddCategory(dto);
		return isCategoryAdded ? "Category Added" : "Category not added";
	}
	@PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addProduct(@RequestParam("productData") String productJson, @RequestParam("file") MultipartFile file)throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		AddProductDto dto = mapper.readValue(productJson, AddProductDto.class);
		dto.setFile(file);
		boolean isProductAdded = sellerServiceImpl.isAddProduct(dto);
		return isProductAdded ? "Product Added" : "Product not added";
	}

	@PostMapping(value ="/editProductData" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public String editProduct(@RequestParam ("editProductData") String editProductJson,@RequestParam("editFile") MultipartFile file)throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		EditProductDto dto = mapper.readValue(editProductJson, EditProductDto.class);
		dto.setFile(file);
		boolean isProductEdited = sellerServiceImpl.editProduct(dto);
		return isProductEdited ? "Product edited" : "Product not edited";
	}

	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int prodId) {
		boolean isProductDeleted = sellerServiceImpl.deleteProduct(prodId);
		return isProductDeleted ? "Product deleted" : "Product not deleted";
	}
	
	@PostMapping("/viewProductsOfSeller")
	public List<ViewProductDto> viewProductOfSeller(int sellerId) {
		return sellerServiceImpl.viewProductOfSeller(sellerId);
		
	}
}
