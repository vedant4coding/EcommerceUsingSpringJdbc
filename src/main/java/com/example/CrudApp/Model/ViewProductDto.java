package com.example.CrudApp.Model;
import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewProductDto {
        private int prodId;
	    private String prodname;
	    private String proddesc;
	    private BigDecimal price;
	    private int discount;
	    private int quantity;
	    private String categoryname;
	    private BigDecimal rating;
	    private int sellerId;
	    private String productImgName;
	    private String imageUrl;
}
