package com.dimitrisli.springJdbcOracle.orm;

import com.dimitrisli.springJdbcOracle.model.Location;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LocationRowMapper implements RowMapper<String> {

    @Override
    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new String(rs.getString("1"));
    }
}
