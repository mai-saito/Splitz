package com.splitz.api.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String email;
    private Date createdAt;
    private Date updatedAt;
}
