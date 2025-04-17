package com.example.CrudApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private BigDecimal rating;
    private String feedback;
    private int userId;
    private int prodId;
}

