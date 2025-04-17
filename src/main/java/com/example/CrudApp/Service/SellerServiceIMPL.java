package com.example.CrudApp.Service;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.CrudApp.Model.AddCategoryDto;
import com.example.CrudApp.Model.AddProductDto;
import com.example.CrudApp.Model.EditProductDto;
import com.example.CrudApp.Model.Product;
import com.example.CrudApp.Model.ViewProductDto;
import com.example.CrudApp.Repository.SellerRepository;

@Service
public class SellerServiceIMPL implements SellerService{
	@Autowired
	private SellerRepository sellerRepositoryImpl;

	 @Value("${category.image}")
	 private String path1;

	@Override
	public boolean isAddCategory(AddCategoryDto addCategory) throws IOException {
		// TODO Auto-generated method stub
		String categoryFileName = addCategory.getFile().getOriginalFilename();
		
		String randomId = UUID.randomUUID().toString();
		String FileName1 = randomId.concat(categoryFileName.substring(categoryFileName.lastIndexOf('.')));
		String fullPath = path1 + File.separator + FileName1;
		
		File f = new File(path1);
		if(!f.exists()) {
			f.mkdir();
		}
		addCategory.setCategoryImgName(FileName1);
		
		Files.copy(addCategory.getFile().getInputStream(), Paths.get(fullPath));
		
		return sellerRepositoryImpl.isAddCategory(addCategory);
	}
	   @Value("${product.image}")
	    private String path;

	@Override
	public boolean isAddProduct(AddProductDto addProduct) throws IOException {
		// TODO Auto-generated method stub
		String FileName = addProduct.getFile().getOriginalFilename();
		
		String randomId = UUID.randomUUID().toString();
		String FileName1 = randomId.concat(FileName.substring(FileName.lastIndexOf('.')));
		String fullPath = path + File.separator + FileName1;
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		addProduct.setProductImgName(FileName1);
		
		Files.copy(addProduct.getFile().getInputStream(), Paths.get(fullPath));
		
		return sellerRepositoryImpl.isAddProduct(addProduct);
	}
	@Override
	public boolean editProduct(EditProductDto editProduct) throws IOException {
	    // Get the original file name of the new image
	    String fileName = editProduct.getFile().getOriginalFilename();
	    
	    // Generate a unique file name
	    String randomId = UUID.randomUUID().toString();
	    String newFileName = randomId.concat(fileName.substring(fileName.lastIndexOf('.')));
	    String fullPath = path + File.separator + newFileName;
	    
	    // Create directory if it doesn't exist
	    File dir = new File(path);
	    if (!dir.exists()) {
	        dir.mkdir();
	    }
	    // Set new image name in DTO
	    editProduct.setProductImgName(newFileName);
	    
	    // Save the new image
	    Files.copy(editProduct.getFile().getInputStream(), Paths.get(fullPath));

	    // Update the product details in DB
	    return sellerRepositoryImpl.editProduct(editProduct);
	}

	@Override
	public boolean deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		return sellerRepositoryImpl.deleteProduct(prodId);
	}
	@Override
	public List<ViewProductDto> viewProductOfSeller(int sellerId) {
		List<Product> list = sellerRepositoryImpl.isViewProducts(sellerId);
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

}
