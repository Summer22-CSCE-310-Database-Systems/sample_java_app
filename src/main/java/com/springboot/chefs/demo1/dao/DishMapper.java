package com.springboot.chefs.demo1.dao;

import org.springframework.jdbc.core.RowMapper;
import com.springboot.chefs.demo1.models.DishInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishMapper implements RowMapper<DishInfo>{
	public DishInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		DishInfo di = new DishInfo();
		di.dname = rs.getString("dname");
		di.cid = rs.getInt("cid");
		di.id = rs.getInt("id");
		di.ddetail = rs.getString("ddetail");
		return di;
	}
}
