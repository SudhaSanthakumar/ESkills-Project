package com.example.wsec.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wsec.model.Page;
import com.example.wsec.model.Role;
import com.example.wsec.model.User;
import com.example.wsec.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes({"user","user_role","user_pages"})
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin/home")
	public String showAdminHome() {
		return "adminHome";
	}
	
//	@RequestMapping("/admin/logout")
//	public String userLogout(ModelMap model,HttpSession session) {
//		
//		model.addAttribute("user",null);
//		model.addAttribute("user_role", null);
//		model.addAttribute("user_pages", Arrays.asList("Home","About"));
//		session.setAttribute("user", null);
//		return "home";
//	}
	
	@RequestMapping("/admin/User")
	public String userLogout(ModelMap model) {
		
		List<User> users=userService.findAllUsers();
		model.addAttribute("usersList",users);
		return "usersPage";
	}
	
	@RequestMapping("/admin/addUser")
	public String addUserPage(ModelMap model) {
		
		List<User> users=userService.findAllUsers();
		model.addAttribute("usersList",users);
		return "addUserPage";
	}
	
	
	
	@RequestMapping("/admin/showUser/{id}")
	public String userLogout(ModelMap model, @PathVariable ("id") int id) {
		System.out.println("id "+id);
		Optional<User> user=userService.findUserById(id);
		System.out.println("user "+user.get().getUserName()	);
		model.addAttribute("retrievedUser",user.get());
		return "userProfile";
	}
	
	@RequestMapping (value = "/addNewUser", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest req, HttpServletResponse res, ModelMap model, HttpSession session) {
		System.out.println("un in post "+req.getParameter("userName"));
		System.out.println("pw in post "+req.getParameter("password"));
		User u=userService.saveUser(req.getParameter("userName"),req.getParameter("password"), req.getParameter("confirmPassword"), req.getParameter("role"));
		System.out.println("user ++++++++++++++++"+u.getUserName()+"   "+u.getRole());
		
		return "redirect:admin/User";
	}

}
