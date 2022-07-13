package com.springboot.chefs.demo1.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.chefs.demo1.models.ChefsInfo;

@Repository
public class ChefsInfoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean CreateChef(ChefsInfo ci) {
		try {
			//INSERT INTO chefs1."ChefsInfo"(cname, address, phone, id) VALUES ('hdjsdk','jdsds','sdfsd',1);
			if(ci.cname.length()==0 || ci.phone.length()==0 || ci.address.length()==0)
				return false;
			String cmd = String.format("INSERT INTO chefs1.\"ChefsInfo\"(cname, address, phone)"
					+ "	VALUES ('{%s}','{%s}','{%s}');",ci.cname,ci.address,ci.phone);
			jdbcTemplate.execute(cmd);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean DeleteChef(int id) {
		try {
			//DELETE FROM chefs1."ChefsInfo" WHERE <condition>;
			String cmd = String.format("DELETE FROM chefs1.\"ChefsInfo\" WHERE	id=%d",id);
			jdbcTemplate.execute(cmd);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean UpdateChef(ChefsInfo ci) {
		try {
			//UPDATE chefs1."ChefsInfo"SET cname='HHH', address='PPP', phone='43543', id=2 WHERE id=2;
			String cmd = String.format("UPDATE chefs1.\"ChefsInfo\" SET	cname='%s', address='%s', phone='{%s}' "
					+ "WHERE id=%d",ci.cname,ci.address,ci.phone,ci.id);
			jdbcTemplate.execute(cmd);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String QueryChefFromAddress(ChefsInfo ci) {
		try {
			//SELECT cname FROM chefs1."ChefsInfo" WHERE address='jdsds';
			String cmd = String.format("SELECT cname FROM chefs1.\"ChefsInfo\" WHERE address=?;");
			String chefname = (String) jdbcTemplate.queryForObject(cmd, new Object[] { ci.address }, String.class);
			return chefname;
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return "index";
		}
	}
	
	public ChefsInfo QueryOneChef(int id) {
		try {
			String cmd = String.format("SELECT id,cname,address,phone FROM chefs1.\"ChefsInfo\" WHERE id=%d ORDER BY cname ASC ;",id);
			List<ChefsInfo> allchefs = jdbcTemplate.query(cmd, new ChefMapper());
			return allchefs.get(0);
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<ChefsInfo> GetAllChefs() {
		try {
			//SELECT cname FROM chefs1."ChefsInfo" ORDER BY id ASC ;
			String cmd = String.format("SELECT id,cname,address,phone FROM chefs1.\"ChefsInfo\" ORDER BY id ASC ;");
			List<ChefsInfo> allchefs = jdbcTemplate.query(cmd, new ChefMapper());
			return allchefs;
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return new ArrayList<ChefsInfo>();
		}
	}
	
	public ChefsInfo GetChefFromAddress (String address) {
		try {
			String cmd = String.format("SELECT id,cname,address,phone FROM chefs1.\"ChefsInfo\" WHERE address='%s' ORDER BY cname ASC ;",address);
			List<ChefsInfo> allchefs = jdbcTemplate.query(cmd, new ChefMapper());
			return allchefs.get(0);
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return null;
		}
	}
}
