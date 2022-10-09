package com.splitz.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.splitz.api.entity.Group;

@Repository
public class GroupRepository extends RepositoryBase<Group> {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    // Get group data from groups
    public Group find(Integer id) {
        try {
            String sql = "SELECT * FROM groups WHERE id = :id";
            SqlParameterSource params = this.bindParams("id", id);
            return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Group.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: Exception handling
            throw e;
        }
    }

    // Get the list of groups the user joins
    public List<Group> findAll(Integer userId) {
        try {
            String sql = "SELECT g.* FROM `groups` AS g INNER JOIN `user_group_participation` AS p ON g.id = p.group_id WHERE p.user_id = :user_id";
            SqlParameterSource params = this.bindParams("user_id", userId);
            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Group.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: Exception handling
            throw e;
        }
    }
}
