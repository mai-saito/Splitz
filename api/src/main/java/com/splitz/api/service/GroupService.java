package com.splitz.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.splitz.api.dto.GroupDto;
import com.splitz.api.dto.UserDto;
import com.splitz.api.entity.Group;
import com.splitz.api.entity.User;
import com.splitz.api.repository.GroupRepository;
import com.splitz.api.repository.UserRepository;

@Service
public class GroupService {

    private UserRepository userRepository;
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    // Get group data
    public GroupDto getGroup(Integer id) {

        try {
            // Get group data from groups
            Group group = groupRepository.find(id);

            // Get the list of users in the group
            List<User> users = userRepository.findAll(id);

            // Map user and groups to UserDto
            return this.mapGroupDto(group, users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: Exception handling
            throw e;
        }
    }

    // Map data to each field of GroupDto
    @ModelAttribute
    private GroupDto mapGroupDto(Group group, List<User> users) {
        return new GroupDto(
            group.getId(),
            group.getGroupName(),
            group.getSettings(),
            users
        );
    }
}
