//package com.example.CrudApp.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.CrudApp.Model.ViewProductDto;
//import com.example.CrudApp.Service.BuyerService;
//
//@RestController
//@RequestMapping("/Buyer")
//public class BuyerController {
//	@Autowired
//	BuyerService buyerServiceImpl;
//	
//	@GetMapping("/viewProducts")
//	public List<ViewProductDto> viewProducts() {
//		return buyerServiceImpl.viewProducts();
//	}
//}

package com.example.CrudApp.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.CrudApp.Model.ViewCategoryDto;
import com.example.CrudApp.Model.ViewProductDto;
import com.example.CrudApp.Service.BuyerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Buyer")
public class BuyerController {

	@Autowired
	BuyerService buyerServiceImpl;

	// Endpoint to fetch product list with image URLs
	@GetMapping("/viewProducts")
	public List<ViewProductDto> viewProducts() {
		return buyerServiceImpl.viewProducts();
	}

	// Inject the image path from application.properties
	@Value("${product.image}")
	private String imagesPath;

	// Endpoint to serve image files
	@GetMapping("/images/{imageName}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String imageName) throws IOException {
		File file = new File(imagesPath + File.separator + imageName);

		if (!file.exists()) {
			return ResponseEntity.notFound().build();
		}

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + imageName)
				.contentLength(file.length()).contentType(MediaType.IMAGE_JPEG) // You can change this based on your
																				// image type
				.body(resource);
	}

	@GetMapping("/viewCategories")
	public List<ViewCategoryDto> viewCategories() {

		List<ViewCategoryDto> catDto = buyerServiceImpl.viewCategories();
		System.out.println(catDto);
		return buyerServiceImpl.viewCategories();
	}

	@Value("${category.image}")
	private String categoryImagesPath;

	@GetMapping("/categoryImages/{imageName}")
	public ResponseEntity<InputStreamResource> getCategoryImage(@PathVariable String imageName) throws IOException {
		File file = new File(categoryImagesPath + File.separator + imageName);

		if (!file.exists()) {
			return ResponseEntity.notFound().build();
		}

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + imageName)
				.contentLength(file.length()).contentType(MediaType.IMAGE_JPEG) // You can change this based on your
																				// image type
				.body(resource);
	}

	@GetMapping("/viewProductsByCategoryId")
	public List<ViewProductDto> viewProductsByCategoryId(@RequestParam int categoryId) {
		return buyerServiceImpl.viewProductsByCategoryId(categoryId);
	}
}
