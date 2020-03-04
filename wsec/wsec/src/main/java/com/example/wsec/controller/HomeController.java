package com.example.wsec.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.PagesPerMinute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.wsec.model.Message;
import com.example.wsec.model.Page;
import com.example.wsec.model.Role;
import com.example.wsec.model.User;
import com.example.wsec.service.UserService;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes({"user_role","user","user_pages"})
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	

	@RequestMapping("/")
	public String showHome(ModelMap model, HttpSession session) {
		updateSession(null,null,Arrays.asList(new Page("Home"),new Page("About")), session);
		return "home";
	}
	
	private void updateSession(User user, String userRole, List<Page> pages, HttpSession session) {
		
		session.setAttribute("user",user);
		session.setAttribute("user_role", userRole);
		session.setAttribute("user_pages", pages);
	}
private void updateModel(User user, String userRole, List<Page> pages, ModelMap model) {
		
		model.addAttribute("user",user);
		model.addAttribute("user_role", userRole);
		model.addAttribute("user_pages", pages);
	}

	@RequestMapping("/showLogin")
	public String showLogin() {
		return "showLogin";
	}
	

	@RequestMapping("/showRegistrationForm")
	public String showRegistrationForm() {
		return "showRegistrationForm";
	}
	@RequestMapping (value = "/uu", method = RequestMethod.POST)
	public String doLoginUser(HttpServletRequest req, HttpServletResponse res, ModelMap model, HttpSession session) {
		System.out.println("un in post "+req.getParameter("userName"));
		System.out.println("pw in post "+req.getParameter("password"));
		User u=userService.findByUserName(req.getParameter("userName"),req.getParameter("password"));

		List<Role> roles=new ArrayList<Role>();
		roles.addAll(u.getRole());
		String role=roles.get(0).getRoleName();
		
		
		
		if(u!=null) {
			
			Set<Page> pages=new HashSet<Page>();
			for(Role r:u.getRole()) {
				pages.addAll(r.getPages());
			}
			List<Page> pageList=new ArrayList<Page>();
			pageList.addAll(pages);
			
			updateSession(u,role.toLowerCase(),pageList, session);
			updateModel(u,role.toLowerCase(),pageList, model);
			if(role.equals("USER"))
			return "redirect:user/home";
			else
			return "redirect:admin/home";
		
		}
		updateSession(null,null,Arrays.asList(new Page("Home"),new Page("About")), session);
		return "redirect:showLogin";
	}
	
	
	@RequestMapping("/logout")
	public String userLogout(ModelMap model, HttpSession session) {
		updateSession(null,null,Arrays.asList(new Page("Home"),new Page("About")), session);
		model.clear();
		return "home";
	}

	@RequestMapping (value = "/doRegister", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest req, HttpServletResponse res, ModelMap model, HttpSession session) {
		System.out.println("un in post "+req.getParameter("userName"));
		System.out.println("pw in post "+req.getParameter("password"));
		User u=userService.saveUser(req.getParameter("userName"),req.getParameter("password"), req.getParameter("confirmPassword"));
		System.out.println("user ++++++++++++++++"+u.getUserName()+"   "+u.getRole());
		List<Role> roles=new ArrayList<Role>();
		roles.addAll(u.getRole());
		String role=roles.get(0).getRoleName();
		
		
		
		if(u!=null) {
			
			Set<Page> pages=new HashSet<Page>();
			for(Role r:u.getRole()) {
				pages.addAll(r.getPages());
			}
			List<Page> pageList=new ArrayList<Page>();
			pageList.addAll(pages);
			
			updateSession(u,role.toLowerCase(),pageList, session);
			updateModel(u,role.toLowerCase(),pageList, model);
			if(role.equals("USER"))
			return "redirect:user/home";
			else
			return "redirect:admin/home";
		
		}
		updateSession(null,null,Arrays.asList(new Page("Home"),new Page("About")), session);
		return "redirect:showLogin";
	}
	
	
}
