package com.stockmanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stockmanager.models.User;
import com.stockmanager.service.UserService;

@Controller
public class LoginController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newuser";
	}

	@RequestMapping("/createaccount")
	public String crateAccount() {
		return "accountcreated";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String crateAccount(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "newuser";
		}

		user.setAuthority("user");
		user.setEnabled(true);

		if (userService.exist(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exist.");
			return "newuser";
		}

		userService.createUser(user);

		return "accountcreated";
	}

}
