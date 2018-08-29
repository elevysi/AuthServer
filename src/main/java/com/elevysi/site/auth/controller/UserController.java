package com.elevysi.site.auth.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elevysi.site.auth.entity.User;
import com.elevysi.site.auth.service.UserService;
import com.elevysi.site.auth.utils.ActiveUser;
import com.elevysi.site.commons.pojo.ReturnValue;
import com.elevysi.site.commons.pojo.SessionMessage;



@Controller
public class UserController extends AbstractController{
	
	
	@Autowired
	private UserService userService;

//	@Autowired
//	private RoleService roleService;
	
	
	@ModelAttribute("user")
	public User constructUser(){
		User user = new User();
		
		return user;
	}
	
	
	@RequestMapping(value = {"/modal/login"}, method = RequestMethod.GET)
	public String loginModal(Model model, @RequestParam(required = false) String message, HttpServletRequest request){
		model.addAttribute("message", message);
		
		return "dialogLogin";
	}
	
	
	@RequestMapping(value = {"/loginExpired"}, method = RequestMethod.GET)
	public String loginExpired(Model model, @RequestParam(required = false) String message, HttpServletRequest request){
		model.addAttribute("message", message);
		
		String referrer = request.getHeader("Referer");
	    if(referrer!=null){
	        request.getSession().setAttribute("url_prior_login", referrer);
	    }
		
		return "userLogin";
	}
	
	
	@RequestMapping(value = "/auth/successlogin")
 	public String loginSuccess(RedirectAttributes redirectAttributes) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ActiveUser activeUser = (ActiveUser)auth.getPrincipal();
		
		String username = activeUser.getUsername();
		User domainUser = userService.findByUsername(username);
		
		String message = "Welcome "+domainUser.getFirst_name()+". You are successfully logged in.";
		SessionMessage sessionMessage = new SessionMessage(message);
		sessionMessage.setSuccessClass();
		redirectAttributes.addFlashAttribute("sessionMessage", sessionMessage);
		
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/denied")
 	public String denied() {
		
		return "pageDenied";
	}
	
	@RequestMapping(value = {"/auth/failure", "/login/failure"})
 	public String loginFailure(RedirectAttributes redirectAttributes) {
		
		SessionMessage sessionMessage = new SessionMessage("Invalid username or password!");
		sessionMessage.setDangerClass();
		redirectAttributes.addFlashAttribute("sessionMessage", sessionMessage);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/auth/modal/failure")
 	public @ResponseBody Boolean modalLoginFailure(RedirectAttributes redirectAttributes) {
		
		return false;
	}
	
	@RequestMapping(value = "/auth/rqstd/failure")
 	public String requestedLoginFailure(RedirectAttributes redirectAttributes) {
		
		SessionMessage sessionMessage = new SessionMessage("Invalid username or password!");
		sessionMessage.setDangerClass();
		redirectAttributes.addFlashAttribute("sessionMessage", sessionMessage);
		
		return "redirect:/auth/rqstd/login";
	}
	
	@RequestMapping(value = "/logout/ajax/page/success")
 	public String logoutSuccess(RedirectAttributes redirectAttributes) {
		SessionMessage sessionMessage = new SessionMessage("Successfully logged out !");
		sessionMessage.setDangerClass();
		redirectAttributes.addFlashAttribute("sessionMessage", sessionMessage);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/logout/ajax/success")
	public @ResponseBody ReturnValue ajaxLogout(){
		ReturnValue returnValue = new ReturnValue();
		returnValue.setCode(1);
		returnValue.setMessage("Successfully logged out");
		return returnValue;
		
	}
	
	
	
	
	@RequestMapping("/users/viewProfile/{id}")
	public String viewUserProfile(@PathVariable("id")String id){
//		Integer userId = Integer.parseInt(id);
//		User user = userService.findOne(userId);
//		ProfileType userProfileType = profileTypeService.findOne("user");
//		Profile userProfile = profileService.findByUserAndProfileType(user, userProfileType);
//		if(userProfile != null){
//			return "redirect:/profile?username="+userProfile.getName();
//		}
		
		return "/";
	}
	
	@RequestMapping(value="/login/issessionvalid", method = RequestMethod.GET)
	public @ResponseBody Boolean isSessionValid(Principal principal){
		boolean returnValue = false;
		
		
		if(principal != null){
			returnValue = true;
		}
		return returnValue;
	}
	
	@RequestMapping(value="/users/dialoglogin", method = RequestMethod.GET)
	public String dialogLogin(){
		
		return "dialogLogin";
		
	}
	
	@RequestMapping(value="updatePassword")
	public String updatePassword(Model model, @ModelAttribute("sessionMessage") 
	SessionMessage sessionMessage){
//		Profile actingProfile = profileService.getActiveProfile();
//		model.addAttribute("actingProfile", actingProfile);
//		model.addAttribute("profile", actingProfile);
//		model.addAttribute("sessionMessage", sessionMessage);
		return "userPasswordUpdate";
	}
	
	@RequestMapping(value="updatePassword", method=RequestMethod.POST)
	public String doUpdatePassword(Model model, RedirectAttributes redirectAttributes, 
			@RequestParam("currentPassword")String currentPassword,
			@RequestParam("newPassword")String newPassword,
			@RequestParam("passwordAgain")String passwordAgain
	){
		
		SessionMessage sessionMessage = new SessionMessage();
		sessionMessage.setMsgText("Failed to update the password!");
		sessionMessage.setDangerClass();
		boolean successOperation = false;
		
		if(currentPassword != null && !currentPassword.isEmpty()){
			if(userService.comparePasswords(currentPassword)){
				if(newPassword != null && !newPassword.isEmpty() && newPassword.length() >=5 ){
					
					if(newPassword.equals(passwordAgain)){
						User savedUser = userService.updatePassword(newPassword);
						if(savedUser != null){						
							successOperation = true;
							sessionMessage.setMsgText("The password was successfully updated!");
							sessionMessage.setSuccessClass();
						}else{
							sessionMessage.setMsgText("Failed to update the password.");
							sessionMessage.setDangerClass();
						}
					}else{
						sessionMessage.setMsgText("The password confirmation does not match.");
						sessionMessage.setDangerClass();
					}
					
				}else{
					sessionMessage.setMsgText("You must provide a new password with at least 5 characters");
					sessionMessage.setDangerClass();
				}
			}else{
				sessionMessage.setMsgText("Your supplied password does not match the stored password.");
				sessionMessage.setDangerClass();
			}
		}else{
			sessionMessage.setMsgText("You must provide your current password first.");
			sessionMessage.setDangerClass();
		}
		
		redirectAttributes.addFlashAttribute("sessionMessage", sessionMessage);
		System.out.println(sessionMessage.getMsgText());
		if(successOperation){
			return "redirect:/";
		}else{
			return "redirect:/updatePassword";
		}
		
	}
	
//	@RequestMapping(value = {"/users/login", "/users/login/", "/login", "login/", "/auth/rqstd/login"}, method = RequestMethod.GET)
//	public String 	login(Model model, @RequestParam(required = false) String message, RedirectAttributes redirectAttributes, final HttpServletRequest request, @ModelAttribute("sessionMessage") SessionMessage sessionMessage){
//		
//		/**
//		 * Check if not logged in already
//		 */
//		ActiveUser activeUser = userService.getActiveUser();
//		
//		if(activeUser != null){
//			
//			SessionMessage sessionWarning = new SessionMessage("A user is already logged in!");
//			sessionWarning.setWarmingClass();
//			
//			redirectAttributes.addFlashAttribute("sessionMessage", sessionWarning);
//			final String referer = request.getHeader("referer");
////			return "redirect:"+referer;
//			
//			return "redirect:/";
//			
//		}
//		
//		if(sessionMessage != null){
//			model.addAttribute("sessionMessage", sessionMessage);
//		}
//		Integer loginRequestMapCode = 0;
//		
//		String pattern = (String)request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
//		
//		if(pattern.equalsIgnoreCase("/auth/rqstd/login")){
//			loginRequestMapCode = 1;
//		}
//		
//		model.addAttribute("loginRequestMapCode", loginRequestMapCode);
//		model.addAttribute("message", message);		
//		return "userLogin";
//	}
	
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String oauth2login(Model model){
		return "userLogin";
	}
	
	
}
