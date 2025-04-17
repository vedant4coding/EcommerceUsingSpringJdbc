package com.example.CrudApp.Model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditProductDto {
    private Integer prodId;
    private String prodName;
    private String prodDesc;
    private Integer price;
    private Integer quantity;
    private Integer discount;
    private String productImgName;
    // Getters and setters
    private MultipartFile file;
}
