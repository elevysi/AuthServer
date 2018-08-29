package com.elevysi.site.auth.controller.rest;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elevysi.site.auth.config.security.jwt.OAuth2AuthenticationUser;
import com.elevysi.site.auth.entity.User;
import com.elevysi.site.auth.service.UserService;
import com.elevysi.site.auth.utils.ActiveUser;
import com.elevysi.site.commons.dto.UserDTO;

@RestController
public class RestUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/user", produces="application/json")
	public @ResponseBody Map<String, Object> user(OAuth2AuthenticationUser user){
		
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		
		return userInfo;
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/user")
//	@RequestMapping(value="/api/user", produces="application/json")
//    public Principal principal(Principal principal) {
//        return principal;
//    }
	
	
//	@RequestMapping(value="/user", produces="application/json")
//	public @ResponseBody ActiveUser user(@AuthenticationPrincipal ActiveUser activeUser){
//		return activeUser;
//	}
	
	@RequestMapping(value="/ui/public/user/{username}", produces="application/json")
	public @ResponseBody UserDTO user(@PathVariable("username") String username){
		return userService.findUserDTOByUsername(username);
	}
	
	@RequestMapping(value="/api/public/user/{username}", produces="application/json")
	public @ResponseBody UserDTO userAPi(@PathVariable("username") String username){
		return userService.findUserDTOByUsername(username);
	}
}
