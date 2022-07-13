package com.springboot.chefs.demo1.models;



public class ChefsInfo {
	public int id;
	public String cname;
	 public String address;
	 public String phone;
	 
	 
	 public int getid()
	 {
		 return id;
	 }
	 
	 public String getcname()
	 {
		 return cname;
	 }
	 
	 public String getaddress()
	 {
		 return address;
	 }
	 
	 public String getphone()
	 {
		 return phone;
	 }
	 
	 public void setid(int id)
	 {
		 this.id = id;
	 }
	 
	 public void setcname(String cname)
	 {
		 this.cname = cname;
	 }
	 
	 public void setaddress(String address)
	 {
		 this.address = address;
	 }
	 
	 public void setphone(String phone)
	 {
		 this.phone = phone;
	 }
}
