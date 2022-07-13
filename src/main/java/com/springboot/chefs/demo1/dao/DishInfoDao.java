package com.springboot.chefs.demo1.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.chefs.demo1.models.ChefDish;
import com.springboot.chefs.demo1.models.ChefsInfo;
import com.springboot.chefs.demo1.models.DishInfo;

@Repository
public class DishInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean CreateDish(DishInfo dish) {
		try {
			//INSERT INTO chefs1."Dish"(dname, ddetail , cid) VALUES ('hdjsdk','jdsds',1);
			if(dish.dname.length()==0 || dish.ddetail.length()==0)
				return false;
			
			
			String cmd = String.format("INSERT INTO chefs1.\"Dish\"(dname, ddetail, cid)"
					+ "	VALUES ('{%s}','{%s}','%d');",dish.dname,dish.ddetail,dish.cid);
			
			
			
			jdbcTemplate.execute(cmd);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<ChefDish> GetChefFromDish(String dishname) {
		try {			
//			SELECT cname,address,chefs1."Dish".dname,chefs1."Dish".dname 
//			FROM	chefs1."ChefsInfo"	INNER JOIN chefs1."Dish"   ON chefs1."ChefsInfo".id = chefs1."Dish".cid 
//			WHERE chefs1."Dish".id=1;
			String cmd = String.format("SELECT chefs1.\"Dish\".id,cname,address,chefs1.\"Dish\".dname,chefs1.\"Dish\".ddetail "
					+ "	FROM  chefs1.\"ChefsInfo\" INNER JOIN chefs1.\"Dish\" ON chefs1.\"ChefsInfo\".id = chefs1.\"Dish\".cid "
					+ "	WHERE chefs1.\"Dish\".dname='%s' ORDER BY cname;",dishname);
			List<ChefDish> allchefs = jdbcTemplate.query(cmd, new ChefDishMapper());
			return allchefs;
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return new ArrayList<ChefDish>();
		}
	}
	
	
	public List<DishInfo> GetAllDishes() {
		try {
			//SELECT dname FROM chefs1."Dish" ORDER BY id ASC ;
			String cmd = String.format("SELECT id,dname,ddetail,cid FROM chefs1.\"Dish\" ORDER BY id ASC ;");
			List<DishInfo> alldishes = jdbcTemplate.query(cmd, new DishMapper());
			return alldishes;
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return new ArrayList<DishInfo>();
		}
	}
	
	public List<DishInfo> QueryDishesForChef(int id) {
		try {
			//SELECT dname FROM chefs1."Dish" ORDER BY id ASC ;
			String cmd = String.format("SELECT id,dname,ddetail,cid FROM chefs1.\"Dish\" WHERE cid=%d ORDER BY id ASC ;",id);
			List<DishInfo> alldishes = jdbcTemplate.query(cmd, new DishMapper());
			return alldishes;
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return new ArrayList<DishInfo>();
		}
	}
	
	public DishInfo QueryOneDish(int id) {
		try {
			String cmd = String.format("SELECT id,dname,ddetail,cid FROM chefs1.\"Dish\" WHERE id=%d ORDER BY dname ASC ;",id);
			List<DishInfo> alldishes = jdbcTemplate.query(cmd, new DishMapper());
			return alldishes.get(0);
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean UpdateDish(DishInfo dish) {
		try {
			String cmd = String.format("UPDATE chefs1.\"Dish\" SET	dname='%s', ddetail='%s', cid='%d' "
					+ "WHERE id=%d",dish.dname,dish.ddetail,dish.cid,dish.id);
			jdbcTemplate.execute(cmd);
			return true;
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean DeleteDishByCid(int cid) {
		try {
			String cmd = String.format("DELETE FROM chefs1.\"Dish\" WHERE	cid=%d",cid);
			jdbcTemplate.execute(cmd);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
		
}
