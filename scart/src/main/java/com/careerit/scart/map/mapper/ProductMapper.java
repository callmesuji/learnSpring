package com.careerit.scart.map.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.careerit.scart.domain.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p = new Product();
		p.setPid(rs.getInt("pid"));
		p.setName(rs.getString("name"));
		p.setDescription(rs.getString("description"));
		p.setPrice(rs.getDouble("price"));
		return p;
	}

}
