package com.splitz.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.splitz.api.entity.User;

@Repository
public class UserRepository extends RepositoryBase<User> {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    // Get user data from users
    public User find(Integer id) {
        try {
            String sql = "SELECT * FROM `users` WHERE id = :id";
            SqlParameterSource params = this.bindParams("id", id);
            return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: Exception handling
            throw e;
        }
    }

    // Get the list of users in the group
    public List<User> findAll(Integer groupId) {
        try {
            String sql = "SELECT u.* FROM `users` AS u INNER JOIN `user_group_participation` AS p ON p.user_id = u.id WHERE p.group_id = :group_id";
            SqlParameterSource params = this.bindParams("group_id", groupId);
            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: Exception handling
            throw e;
        }
    }
}
