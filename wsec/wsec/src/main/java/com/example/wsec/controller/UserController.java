package com.example.wsec.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wsec.model.Message;
import com.example.wsec.model.Page;
import com.example.wsec.model.User;
import com.example.wsec.service.UserService;

@Controller
@SessionAttributes({"user","user_role","user_pages"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping({"/user/home","/user/Home"})
	public String showUserHome() {
		return "userHome";
	}
	

//	@RequestMapping("/user/logout")
//	public String userLogout(ModelMap model, HttpSession session) {
//		System.out.println("------------------------------------------------------------------------------inside user logout");
//		model.clear();
//		model.remove("user");
//		model.addAttribute("user_role", null);
//		model.addAttribute("user_pages", Arrays.asList(new Page("Home"),new Page("About")));
//		session.setAttribute("user", null);
//		return "home";
//	}

	@RequestMapping("/user/Message")
	public String userMessage(ModelMap model) {
		User u=((User)model.getAttribute("user"));
		System.out.println("user looged in       "+((User)model.getAttribute("user")).getUserName());
		List<Message> messages=new ArrayList<Message>();
		messages.addAll(userService.findUserById(u.getUserId()).get().getMessages());
		model.addAttribute("user_messages", messages);
		return "message";
	}

	@RequestMapping("/user/{id}/addMessage")
	public String userMessage(ModelMap model, @PathVariable("id") int id, HttpServletRequest request) {
		User u=((User)model.getAttribute("user"));
		System.out.println("user looged in       "+((User)model.getAttribute("user")).getUserName());
		userService.saveMessage(id, request.getParameter("message"));
		List<Message> messages=new ArrayList<Message>();
		messages.addAll(userService.findUserById(id).get().getMessages());
		model.addAttribute("user_messages", messages);
		return "message";
	}

	
}
