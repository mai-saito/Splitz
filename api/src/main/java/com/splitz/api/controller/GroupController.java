package com.splitz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.splitz.api.dto.GroupDto;
import com.splitz.api.service.GroupService;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    // Show group data
    @GetMapping("/group/{id}")
    public GroupDto getUser(@PathVariable("id") Integer id) {
        return groupService.getGroup(id);
    }
}
