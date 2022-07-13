package com.springboot.chefs.demo1.dao;

import org.springframework.jdbc.core.RowMapper;
import com.springboot.chefs.demo1.models.ChefsInfo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefMapper implements RowMapper<ChefsInfo>{
	public ChefsInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChefsInfo cc = new ChefsInfo();
		cc.cname = rs.getString("cname");
		cc.phone = rs.getString("phone");
		cc.address = rs.getString("address");
		cc.id = rs.getInt("id");
		return cc;
	}
}