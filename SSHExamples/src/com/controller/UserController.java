package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Address;
import com.entity.User;
import com.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(String username, String password, HttpSession session){
		User user = userService.getUser(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			for (Address a : user.getAddresses()) {
				System.out.println(a.getName());
			}
			return "redirect:/index";
		} else {
			return "redirect:/login";
		}
	} 
	@GetMapping("/{view}")
	public void getView() {}
}
