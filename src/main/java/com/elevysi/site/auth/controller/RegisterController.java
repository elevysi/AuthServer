package com.elevysi.site.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elevysi.site.auth.entity.User;
import com.elevysi.site.auth.service.UserService;
import com.elevysi.site.commons.pojo.SessionMessage;


@Controller
@RequestMapping(value="/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User constructUser(){
		User user = new User();
		
		return user;
	}
	

	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public String register(){
	
		return "userRegister";
	}
	
	@RequestMapping(value = {""}, method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result, final RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return "userRegister";
		}
				
		userService.registerUser(user);
		
		SessionMessage sessionMessage = new SessionMessage("Successfully Registered!");
		sessionMessage.setSuccessClass();
		redirectAttributes.addFlashAttribute("sessionMessage", sessionMessage);	
		
		return "redirect:/";
	}
	
	
	
	
	@RequestMapping("/usernameAvailable")
	@ResponseBody
	public String usernameAvailable(@RequestParam String username, @RequestParam(value="update", required = false)String oldUsername){
		Boolean available = false;
		boolean checkForNew = true;
		if(oldUsername != null){
			if(oldUsername.equalsIgnoreCase(username)){
				available = true;
				checkForNew = false;
			} 
		}
		
		if(checkForNew){
			available = userService.findByUsername(username) == null;
		}
		
		return available.toString();
	}
	
	@RequestMapping("/emailRegistered")
	@ResponseBody
	public String emailRegistered(@RequestParam String email, @RequestParam(value="update", required = false)String oldEmail){
		Boolean available = false;
		boolean checkForNew = true;
		if(oldEmail != null){
			if(oldEmail.equalsIgnoreCase(email)){
				available = true;
				checkForNew = false;
			}
		}
		
		if(checkForNew){
			available = userService.findOneWithEmail(email) == null;
		}
		
		return available.toString();
	}

}
