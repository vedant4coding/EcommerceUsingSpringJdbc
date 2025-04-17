package com.example.CrudApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int prodId;
    private String prodname;
    private String proddesc;
    private String productImgName;
    private BigDecimal price;
    private int discount;
    private int quantity;
    private BigDecimal rating;
    private int categoryId;
    private int sellerid;
}
