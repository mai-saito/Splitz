package com.splitz.api.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public abstract class RepositoryBase<T> {

    public abstract T find(Integer id);

    // Bind params
    protected SqlParameterSource bindParams(String key, Object value) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(key, value);
        return params;
    }
}
