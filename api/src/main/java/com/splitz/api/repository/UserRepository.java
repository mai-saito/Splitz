package com.splitz.api.repository;

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
            return jdbcTemplate.queryForObject(sql, params,  new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: Exception handling
            throw e;
        }
    }
}
