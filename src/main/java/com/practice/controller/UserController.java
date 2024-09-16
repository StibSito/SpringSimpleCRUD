package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.model.User;
import com.practice.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService uSer;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("lstUsers", uSer.lstUsers());
		return "index";
	}

	@GetMapping("/chargeForm")
	public String chargeForm(@ModelAttribute User u, Model model) {
		model.addAttribute("user", u);
		return "addUser";
	}

	@PostMapping("/addUser")
	public String addU(User u) {
		uSer.saveUser(u);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idU, Model model) {
		User u = uSer.findUser(idU);
		model.addAttribute("user", u);
		return "addUser";
	}

	@GetMapping("/delete")
	public String delete(User user) {
		uSer.deleteUser(user);
		return "redirect:/";
	}

}
