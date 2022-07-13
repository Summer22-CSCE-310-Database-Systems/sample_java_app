package com.springboot.chefs.demo1.models;


public class ChefDish {
	public int id;
	 public String cname;
	public String address;
	public String dname;
	public String ddetail;
	
	 public int getid()
	 {
		 return id;
	 }
	 
	 public void setid(int id)
	 {
		 this.id = id;
	 }
	 
	 public String getcname()
	 {
		 return cname;
	 }
	 
	 public void setcname(String cname)
	 {
		 this.cname = cname;
	 }
	 
	 public String getaddress()
	 {
		 return address;
	 }
	 
	 public void setaddress(String address)
	 {
		 this.address = address;
	 }
	 
	 public String getdname()
	 {
		 return dname;
	 }
	 
	 public void setdname(String dname)
	 {
		 this.dname = dname;
	 }
	 
	 public String getddetail()
	 {
		 return ddetail;
	 }
	 
	 public void setddetail(String ddetail)
	 {
		 this.ddetail = ddetail;
	 }
}
