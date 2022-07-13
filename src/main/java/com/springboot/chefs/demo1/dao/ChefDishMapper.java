package com.springboot.chefs.demo1.dao;

import org.springframework.jdbc.core.RowMapper;
import com.springboot.chefs.demo1.models.ChefDish;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefDishMapper implements RowMapper<ChefDish> {
	public ChefDish mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChefDish cd = new ChefDish();
		cd.id = rs.getInt("id");
		cd.cname = rs.getString("cname");
		cd.address = rs.getString("address");
		cd.dname = rs.getString("dname");
		cd.ddetail = rs.getString("ddetail");
		return cd;
	}
}