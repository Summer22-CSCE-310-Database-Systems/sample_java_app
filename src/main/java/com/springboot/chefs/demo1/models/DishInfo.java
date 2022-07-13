package com.springboot.chefs.demo1.models;


public class DishInfo {
 public int id;
public String dname;
public String ddetail;
 public int cid;
 
 public int getid()
 {
	 return id;
 }
 
 public String getdname()
 {
	 return dname;
 }
 
 public String getddetail()
 {
	 return ddetail;
 }
 
 public int getcid()
 {
	 return cid;
 }
 
 public void setid(int id)
 {
	 this.id = id;
 }
 
 public void setdname(String dname)
 {
	 this.dname = dname;
 }
 
 public void setddetail(String ddetail)
 {
	 this.ddetail = ddetail;
 }
 
 public void setcid(int cid)
 {
	 this.cid = cid;
 }
 
}
