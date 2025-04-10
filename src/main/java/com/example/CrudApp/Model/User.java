package com.example.CrudApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String name;
    private String username;
    private String email;
    private String contact;
    private String password;
    private String usertype;
    private int loginstatus;
    private java.sql.Timestamp dateinfo;
    private String address;
    private String profileImg;
}
