package com.kb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kb.model.UserModel;
import com.kb.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView homePage(){
		ModelAndView andView = new ModelAndView("index");
		andView.addObject("title", "Home");
		return andView;
	}

	@GetMapping(value = "register")
	public String register(){	
		return "registerPage";
	}
	
	@PostMapping(value = "doRegister")
	public ModelAndView registerSave(@ModelAttribute UserModel model) {
		ModelAndView andView = new ModelAndView("index");
		System.out.println(model);
		System.out.println(userservice);
		userservice.addUser(model);
		return andView;
	}
	
	@GetMapping(value = "/user")
	public String getUsers(Model model)
	{
		List<UserModel> listUser = userservice.listUser();
		listUser.stream().forEach(e->System.out.println(e.getEmail()+" "+e.getName()));
		System.out.println(listUser);
		model.addAttribute("allUsers", listUser);
		return "view";
	}
	
	@RequestMapping(value ="/user/remove/{id}" )
	public String removeUser(@PathVariable("id") int id)
	{
		userservice.removeEmployee(id);
		return "redirect:/view";	
	}
	
	@RequestMapping("/employee/edit/{id}")
	public String editemployee(@PathVariable("id") int id, Model model) {

		return "view";
	}

	
	
}
