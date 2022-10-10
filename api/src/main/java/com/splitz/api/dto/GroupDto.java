package com.splitz.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splitz.api.entity.User;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("group_name")
    private String groupName;

    @JsonProperty("settings")
    private String settings;

    @JsonProperty("user_list")
    private List<User> userList;
}
