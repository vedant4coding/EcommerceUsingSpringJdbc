package com.example.CrudApp.Model;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductDto {
	    private String prodname;
	    private String proddesc;
	    private BigDecimal price;
	    private int discount;
	    private int quantity;
	    private String categoryname;
	    private int sellerId;
	    private String productImgName;
	    private MultipartFile file;
}
