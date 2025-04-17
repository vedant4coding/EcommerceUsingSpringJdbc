package com.example.CrudApp.Model;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryDto {
    private String categoryname;
    private String categoryImgName;
    private MultipartFile file;
}
