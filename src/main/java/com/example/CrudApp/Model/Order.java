package com.example.CrudApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private int userId;
    private int prodId;
    private Timestamp orderdateinfo;
}

