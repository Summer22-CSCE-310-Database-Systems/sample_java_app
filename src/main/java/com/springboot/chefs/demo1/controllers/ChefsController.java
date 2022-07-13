package com.springboot.chefs.demo1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.chefs.demo1.dao.ChefsInfoDao;
import com.springboot.chefs.demo1.dao.DishInfoDao;
import com.springboot.chefs.demo1.models.ChefsInfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChefsController {
	
	@Autowired ChefsInfoDao chefdao;
	@Autowired DishInfoDao dishdao;
		
	@GetMapping("/addChef")
	public String Create() {
		return "forward:/addChef.jsp";
	}
	
	@RequestMapping("/addChefToDb")
	public String CreateDB(HttpServletRequest request, Model model) {
		ChefsInfo cc = new ChefsInfo();
		cc.cname = request.getParameter("chefname");
		cc.address = request.getParameter("address");
		cc.phone = request.getParameter("phone");
		model.addAttribute("back", "/addChef");
		if(cc.phone.length()!=10) { 
			model.addAttribute("msg","phone number incorrect");
			return "forward:/failed.jsp";
		}
			
		boolean success = chefdao.CreateChef(cc);
		if(success) {
			model.addAttribute("msg","successfully added chef "+cc.cname);
			return "forward:/success.jsp";
		}
		else {
			model.addAttribute("msg","failed to add, check your input.");
			return "forward:/failed.jsp";
		}
	}
	
	@RequestMapping("/deleteChef")
	public String Delete(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		model.addAttribute("selected",allchefs.get(0));		
		return "forward:/Delete.jsp";
	}
	
	@RequestMapping("/viewdetails")
	public String ViewDetails(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("chefid"));
		if(id==-1) {
			model.addAttribute("msg","chef not selected");
			model.addAttribute("back","/deleteChef");
			return "forward:/failed.jsp";
		}
		ChefsInfo ci = chefdao.QueryOneChef(id);
		model.addAttribute("chef",ci);
		return "forward:/ViewDetailsDelete.jsp";
	}
	
	
	@RequestMapping("/deleteChefFromDb")
	public String DeleteDB(HttpServletRequest request,Model model) {
		int id = Integer.valueOf(request.getParameter("id"));
		boolean dishdel = dishdao.DeleteDishByCid(id);
		boolean success = chefdao.DeleteChef(id);
		model.addAttribute("back", "/deleteChef");
		if(success) {
			model.addAttribute("msg","successfully deleted");
			return "forward:/success.jsp";
		}
		else {
			model.addAttribute("msg","could not delete");
			return "forward:/failed.jsp";
		}
	}
	
	@RequestMapping("/updateChef")
	public String Update(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "forward:/updateChef.jsp";
	}
	
	@RequestMapping("/updateforonechef")
	public String UpdateForOne(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("chefid"));
		if(id==-1) {
			model.addAttribute("msg","chef not selected");
			model.addAttribute("back","/updateChef");
			return "forward:/failed.jsp";
		}
		ChefsInfo ci = chefdao.QueryOneChef(id);
		model.addAttribute("chef",ci);
		return "forward:/UpdateOneChef.jsp";
	}
	
	@RequestMapping("/updateChefInDb")
	public String UpdateDB(HttpServletRequest request, Model model) {
		ChefsInfo cc = new ChefsInfo();
		cc.id = Integer.valueOf(request.getParameter("id"));
		cc.cname = request.getParameter("chefname");
		cc.address = request.getParameter("address");
		cc.phone = request.getParameter("phone");
		model.addAttribute("back", "/updateChef");
		if(cc.phone.length()!=10) { 
			model.addAttribute("msg","phone number incorrect");
			return "forward:/failed.jsp";
		}
		boolean success = chefdao.UpdateChef(cc);
		if(success) {
			model.addAttribute("msg","successfully updated");
			return "forward:/success.jsp";
		}
		else {
			model.addAttribute("msg","check the values");
			return "forward:/failed.jsp";
		}
	}
	
	@RequestMapping("/cheffromaddress")
	public String QueryNameFromAddress(@RequestBody ChefsInfo ci) {
		return chefdao.QueryChefFromAddress(ci);
	}

	@RequestMapping("/allchefs")
	public String GetAll(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "forward:/viewAllChefs.jsp";
	}
	
	@RequestMapping("/getcheffromaddress")
	public String ListChefsForDishes(Model model) {
		List<ChefsInfo> allchefs =  chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "forward:/ChefFromAddress.jsp";
	}
	
	
	@RequestMapping("/viewchefforaddress")
	public String ListChefsForDishes(HttpServletRequest request, Model model) {
		String address = request.getParameter("address");
		if(address.equals("-- Select --")) {
			model.addAttribute("msg","address not selected");
			model.addAttribute("back","/getcheffromaddress");
			return "forward:/failed.jsp";
		}
		ChefsInfo ci =  chefdao.GetChefFromAddress(address);
		model.addAttribute("chef",ci.cname);
		model.addAttribute("address",address);
		return "forward:/ChefForAnAddress.jsp";
	}
	
}
