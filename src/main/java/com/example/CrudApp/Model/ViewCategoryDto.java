package com.example.CrudApp.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewCategoryDto {
	private String categoryId;
    private String categoryname;
    private String categoryImgName;
//    private MultipartFile file;
    private String categoryImageUrl;
}
