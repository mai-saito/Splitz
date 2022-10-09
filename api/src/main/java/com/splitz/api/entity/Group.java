package com.splitz.api.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Group {
    private Integer id;
    private String groupName;
    private String settings;
    private Date createdAt;
    private Date updatedAt;
}
