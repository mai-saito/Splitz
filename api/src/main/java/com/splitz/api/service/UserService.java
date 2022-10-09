package com.splitz.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.splitz.api.dto.UserDto;
import com.splitz.api.entity.Group;
import com.splitz.api.entity.User;
import com.splitz.api.repository.GroupRepository;
import com.splitz.api.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private GroupRepository groupRepository;

    @Autowired
    public UserService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    // Get user data
    public UserDto getUser(Integer id) {

        try {
            // Get user data from users
            User user = userRepository.find(id);

            // Get the list of groups the user joins
            List<Group> groups = groupRepository.findAll(id);

            // Map user and groups to UserDto
            return this.mapUserDto(user, groups);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: Exception handling
            throw e;
        }
    }

    // Map data to each field of UserDto
    @ModelAttribute
    private UserDto mapUserDto(User user, List<Group> groups) {
        return new UserDto(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            groups
        );
    }
}
