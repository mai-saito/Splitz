package com.splitz.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splitz.api.entity.Group;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("group_list")
    private List<Group> groupList;
}
