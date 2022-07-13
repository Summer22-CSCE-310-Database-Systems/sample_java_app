package com.springboot.chefs.demo1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.chefs.demo1.dao.ChefsInfoDao;
import com.springboot.chefs.demo1.dao.DishInfoDao;
import com.springboot.chefs.demo1.models.ChefDish;
import com.springboot.chefs.demo1.models.ChefsInfo;
import com.springboot.chefs.demo1.models.DishInfo;


@Controller
public class DishController {
	@Autowired ChefsInfoDao chefdao;
	@Autowired DishInfoDao dishdao;
	
	@GetMapping("/addDish")
	public String Create(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "forward:/addDish.jsp";
	}
	
	@RequestMapping("/addDishToDb")
	public String CreateDB(HttpServletRequest request, Model model) {
		DishInfo dish = new DishInfo();
		dish.dname = request.getParameter("chefname");
		dish.ddetail = request.getParameter("address");
		dish.cid = Integer.parseInt(request.getParameter("chefid"));
		model.addAttribute("back", "/addDish");
		if(dish.cid==-1) {
			model.addAttribute("msg","chef not selected");
			return "forward:/failed.jsp";
		}
		boolean success = dishdao.CreateDish(dish);
		if(success) {
			model.addAttribute("msg","successfully added dish"+dish.dname);
			return "forward:/success.jsp";
		}
		else {
			model.addAttribute("msg","failed to add, check your input.");
			return "forward:/failed.jsp";
		}
	}
	
	@RequestMapping("/listdishesforchef")
	public String listDishes(Model model) {
		List<DishInfo> alldishes = dishdao.GetAllDishes();
		model.addAttribute("alldishes",alldishes);
		return "forward:/ListDishes.jsp";
	}
	
	@RequestMapping("/listchefsfordish")
	public String listChefForDish(HttpServletRequest request, Model model) {
		String dishname = request.getParameter("dishname");
		if(dishname.equals("-- Select --")) {
			model.addAttribute("msg","dish not selected");
			model.addAttribute("back","/listdishesforchef");
			return "forward:/failed.jsp";
		}
		List<ChefDish> chefsfordish = dishdao.GetChefFromDish(dishname);
		model.addAttribute("chefsfordish",chefsfordish);
		model.addAttribute("dishname",dishname);
		return "forward:/ViewChefsForDish.jsp";
	}
	
	@RequestMapping("/listchefsfordishes")
	public String ListChefsForDishes(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "forward:/ViewChefsForDishes.jsp";
	}
	
	@RequestMapping("/viewdishes")
	public String ViewDetails(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("chefid"));
		if(id==-1) {
			model.addAttribute("msg","chef not selected.");
			model.addAttribute("back","/listchefsfordishes");
			return "forward:/failed.jsp";
		}
		List<DishInfo> dishes = dishdao.QueryDishesForChef(id);
		model.addAttribute("dishes",dishes);
		return "forward:/ViewDishesForChef.jsp";
	}
	
	@RequestMapping("/updateDish")
	public String Update(Model model) {
		List<DishInfo> alldishes = dishdao.GetAllDishes();
		model.addAttribute("alldishes",alldishes);
		return "forward:/updateDish.jsp";
	}
	
	@RequestMapping("/updateForOneDish")
	public String UpdateForOne(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("dishid"));
		if(id==-1) {
			model.addAttribute("msg","dish not selected");
			model.addAttribute("back","/updateDish");
			return "forward:/failed.jsp";
		}
		DishInfo dish = dishdao.QueryOneDish(id);
		ChefsInfo chef = chefdao.QueryOneChef(dish.cid);
		model.addAttribute("dish",dish);
		model.addAttribute("chef",chef);
		return "forward:/updateOneDish.jsp";
	}
	
	@RequestMapping("/updateDishInDb")
	public String UpdateDB(HttpServletRequest request, Model model) {
		DishInfo dish = new DishInfo();
		dish.id = Integer.parseInt(request.getParameter("id"));
		dish.dname = request.getParameter("dishname");
		dish.ddetail = request.getParameter("ddetail");
		dish.cid = Integer.parseInt(request.getParameter("cid"));
		model.addAttribute("back", "/updateDish");
		boolean success = dishdao.UpdateDish(dish);
		if(success) {
			model.addAttribute("msg","successfully updated");
			return "forward:/success.jsp";
		}
		else {
			model.addAttribute("msg","check the values");
			return "forward:/failed.jsp";
		}
	}
	
	
}
